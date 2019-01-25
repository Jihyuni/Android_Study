package com.sopt.seminar_08

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_my.*

class MyFragment : Fragment() {

    companion object {//static

        private var instance: MyFragment? = null
        fun getInstance(title: String,,content: String): MyFragment {
            if (instance != null) {
                instance = MyFragment().apply {
                    arguments = Bundle().apply {
                        putString("title", title)
                        putString("content", content)
                        putInt("personCnt",personCnt)
                    }
                }

            }
            return instance!!
        }


    }

    var title: String? = null
    var content: String? = null
    var personCnt : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            title = arguments!!.getString("title")
            content = arguments!!.getString("content")

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_my, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        tv_my_fragment_title.text = title
        tv_my_fragment_content.text=content

        //여기서부터 뷰 건드는 코딩
    }
}