package com.sopt.ch7

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.view.ActionMode
import android.view.View
import android.widget.TextView

class FloatingContextMenu : AppCompatActivity() {

    private val colorRed = 1
    private val colorGreen = 2
    private val colorBlue = 3
    internal lateinit var tv:TextView

    lateinit var mActionMode : ActionMode



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_floating_context_menu)

        tv=findViewById<TextView>(R.id.tv_floating_context_menu)
        //registerForContextMenu(tv)
    }



//floating context menu
    /*override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menu?.setHeaderTitle("context menu")
        menu?.add(Menu.NONE,colorRed,Menu.NONE,"background:RED")
        menu?.add(Menu.NONE,colorGreen,Menu.NONE,"background:GREEN")
        menu?.add(Menu.NONE,colorBlue,Menu.NONE,"background:BLUE")
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {

        when(item?.itemId){
            colorRed->{
                tv.setBackgroundColor(Color.RED)
                return true
            }
            colorGreen->{
                tv.setBackgroundColor(Color.GREEN)
                return true
            }
            colorBlue->{
                tv.setBackgroundColor(Color.BLUE)
                return true
            }
        }
        return super.onContextItemSelected(item)
    }*/
}
