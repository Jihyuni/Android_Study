package com.sopt.listviewpractice

import android.net.IpSecManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    val header :MutableList<String> = ArrayList()
    val body : MutableList<MutableList<String>> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "Category"

        val women : MutableList<String> = ArrayList()
        women.add("Outer")
        women.add("Top")
        women.add("Bottom")
        women.add("Act")
        val men : MutableList<String> = ArrayList()
        men.add("Outer")
        men.add("Top")
        men.add("Bottom")
        men.add("Act")


        header.add("         Women")
        header.add("Men")

        body.add(women)
        body.add(men)





        expandableListView.setAdapter(ExpandableAdapter(this,header,body))
        expandableListView.setOnChildClickListener { parent, v, groupPosition, childPosition, id ->
            Log.e("child click", "groupPosition $groupPosition, childPosition $childPosition, id $id")


            var gpos = groupPosition
            var cpos = childPosition

            if(gpos==0&&cpos==0)
            {
                startActivity<SubActivity>()

            }

            return@setOnChildClickListener false


        }



    }


}
