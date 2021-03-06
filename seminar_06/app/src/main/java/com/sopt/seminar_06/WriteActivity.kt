package com.sopt.seminar_06

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v4.content.CursorLoader
import android.util.Log
import com.bumptech.glide.Glide
import com.sopt.seminar_06.db.SharedPreferenceController
import com.sopt.seminar_06.network.ApplicationController
import com.sopt.seminar_06.network.NetworkService
import com.sopt.seminar_06.post.PostWriteBoardResponse
import kotlinx.android.synthetic.main.activity_write.*
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.InputStream

class WriteActivity : AppCompatActivity() {
    val REQUEST_CODE_SELECT_IMAGE: Int = 1004
    private var mImage: MultipartBody.Part? = null

    val My_READ_STORAGE_REQUEST_CODE = 7777

    var imageURI : String? = null


    val networkService: NetworkService by lazy {
        ApplicationController.instance.networkService
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write)
        setOnBtnClickListener()
    }

    private fun setOnBtnClickListener() {
        btn_write_act_show_album.setOnClickListener {
            //앨범 여는 로직
            requestReadExternalStoragePermission()
        }
        btn_write_act_complete.setOnClickListener {
            getWriteBoardResponse()
        }
    }


    private fun requestReadExternalStoragePermission() {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
//첫번째 if문을 통해 과거에 이미 권한 메시지에 대한 OK를 했는지 아닌지에 대해 물어봅니다! if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
                //사용자에게 권한을 왜 허용해야되는지에 메시지를 주기 위한 대한 로직을 추가하려면 이 블락에서 하면됩니다!!
                // 하지만 우리는 그냥 비워놓습니다!! 딱히 줄말 없으면 비워놔도 무관해요!!! 굳이 뭐 안넣어도됩니다!
            } else {
                //아래 코드는 권한을 요청하는 메시지를 띄우는 기능을 합니다! 요청에 대한 결과는 callback으로 onRequestPermissionsResult 메소드에서 받습니다!!!
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), My_READ_STORAGE_REQUEST_CODE)
            }
        }else {
            showAlbum()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) { //onActivityResult와 같은 개념입니다. requestCode로 어떤 권한에 대한 callback인지를 체크합니다.
        if (requestCode == My_READ_STORAGE_REQUEST_CODE) {
//결과에 대해 허용을 눌렀는지 체크하는 조건문이구요!
            if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//이곳은 외부저장소 접근을 허용했을 때에 대한 로직을 쓰시면됩니다. 우리는 앨범을 여는 메소드를 호출해주면되겠죠?
                showAlbum()
            } else {
//이곳은 외부저장소 접근 거부를 했을때에 대한 로직을 넣어주시면 됩니다.
                finish()
            }
        }
    }

    private fun showAlbum(){
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = android.provider.MediaStore.Images.Media.CONTENT_TYPE
        intent.data = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        startActivityForResult(intent, REQUEST_CODE_SELECT_IMAGE)
    }

    //앨범에서 사진을 선택했을때 실행되는 메소드
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_SELECT_IMAGE) {
            if (resultCode == Activity.RESULT_OK) {
                if(data!=null){
                    val selectedImageUri : Uri = data.data

                    imageURI = getRealPathFromURI(selectedImageUri)

                    Glide.with(this@WriteActivity)
                            .load(selectedImageUri)
                            .thumbnail(0.1f)
                            .into(iv_write_act_choice_image)
                }
            }
        }
    }

    fun getRealPathFromURI(content : Uri) : String {
        val proj = arrayOf(MediaStore.Images.Media.DATA)
        val loader : CursorLoader = CursorLoader(this, content, proj, null, null, null)
        val cursor : Cursor? = loader.loadInBackground()
        val column_idx = cursor!!.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
        cursor.moveToFirst()
        val result = cursor.getString(column_idx)
        cursor.close()
        return result
    }

    private fun getWriteBoardResponse() {
        val input_title = et_write_act_title.text.toString()
        val input_contents = et_write_act_content.text.toString()
        if (input_title.isNotEmpty() && input_contents.isNotEmpty()) {
            //Multipart 형식은 String을 RequestBody 타입으로 바꿔줘야 합니다!
            val token = SharedPreferenceController.getAuthorization(this)
            var title = RequestBody.create(MediaType.parse("text/plain"), input_title)
            var contents = RequestBody.create(MediaType.parse("text/plain"), input_contents)

            val file : File = File(imageURI)
            val requestfile : RequestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file)
            val data : MultipartBody.Part = MultipartBody.Part.createFormData("photo", file.name, requestfile)

            val postWriteBoardResponse = networkService.postWriteBoardResponse(token, title, contents, data)

            postWriteBoardResponse.enqueue(object : Callback<PostWriteBoardResponse> {
                override fun onFailure(call: Call<PostWriteBoardResponse>, t: Throwable) {
                    Log.e("write fail", t.toString())
                }

                override fun onResponse(call: Call<PostWriteBoardResponse>, response: Response<PostWriteBoardResponse>) {
                    if (response.isSuccessful) {
                        toast(response.body()!!.message)
                        Log.e("메시지 로그", response.body()!!.message)
                        finish()
                    }
                }
            })
        }
    }
}
