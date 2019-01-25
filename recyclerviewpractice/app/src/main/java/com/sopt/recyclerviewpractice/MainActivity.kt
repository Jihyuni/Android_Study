package com.sopt.recyclerviewpractice

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout
import com.sopt.recyclerviewpractice.adapter.MyStatePagerAdapter
import com.sopt.recyclerviewpractice.db.SharedPreferenceController
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bottom_tab.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configuretab()

        btn_main_act_logout.setOnClickListener {
            SharedPreferenceController.clearUserSharedPreferences(this)
            startActivity<LoginActivity>()
            finish()
        }


    }

    private fun configuretab() {
        vp_bottom_navi_act_frag_pager.adapter = MyStatePagerAdapter(supportFragmentManager, 3)

        tl_bottom_navi_act_bottom_menu.setupWithViewPager(vp_bottom_navi_act_frag_pager)

        val bottomtab: View = this.layoutInflater.inflate(R.layout.bottom_tab, null, false)

        tl_bottom_navi_act_bottom_menu.getTabAt(0)!!.customView = bottomtab.findViewById(R.id.btn_bottom_tab_main) as RelativeLayout
        tl_bottom_navi_act_bottom_menu.getTabAt(1)!!.customView = bottomtab.findViewById(R.id.btn_bottom_tab_mypage) as RelativeLayout
        tl_bottom_navi_act_bottom_menu.getTabAt(2)!!.customView = bottomtab.findViewById(R.id.btn_bottom_tab_map) as RelativeLayout
    }

}
