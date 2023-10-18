package com.example.alldayfit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.example.alldayfit.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: MainActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = MainActivityBinding.inflate(layoutInflater)
        val view = mBinding.root
        setContentView(view)
        setCustomToolbar(R.id.main_toolbar)
    }

    // 툴바 메뉴 버튼을 설정- menu에 있는 item을 연결하는 부분
    fun setCustomToolbar(layout: Int) {
        val toolbar = mBinding.mainToolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        val mTitle = mBinding.toolbarTitle
        mTitle.text = "All_DayFit"
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_toolbar_menu, menu)
        return true
    }

}