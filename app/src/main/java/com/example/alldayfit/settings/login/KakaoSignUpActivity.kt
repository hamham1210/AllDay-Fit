package com.example.alldayfit.settings.login

import android.app.Application
import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import com.example.alldayfit.BuildConfig
import com.example.alldayfit.databinding.CommunityNewpostDialogBinding
import com.example.alldayfit.databinding.SignInPageActivityBinding
import com.kakao.sdk.common.KakaoSdk

class KakaoSignUpActivity: AppCompatActivity() {

    private lateinit var binding: SignInPageActivityBinding

    private lateinit var viewModel: KakaoAuthViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SignInPageActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        KakaoSdk.init(this, BuildConfig.NATIVE_APP_KEY)
        binding.kakaoSignUp.setOnClickListener() {
            viewModel.kakaoHandle()
        }
    }
}
