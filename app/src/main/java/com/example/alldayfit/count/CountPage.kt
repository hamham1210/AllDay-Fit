package com.example.alldayfit.count

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import com.example.alldayfit.R
import com.example.alldayfit.databinding.ActivityCountPageBinding
import com.example.alldayfit.exercisestatus.ExerciseStatusDailyEditDialog


class CountPage : AppCompatActivity() {
    private lateinit var mBinding: ActivityCountPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityCountPageBinding.inflate(layoutInflater)
        val view = mBinding.root
        setContentView(view)
        mBinding.setRootine.setOnClickListener {
            val countDialog = CountDialog()
            countDialog.show(supportFragmentManager, "CountDialogFragment")
        }
    }



}