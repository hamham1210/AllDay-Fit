package com.example.alldayfit.utils

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import com.example.alldayfit.R
import com.example.alldayfit.settings.login.GoogleSignInPage
import com.kakao.sdk.common.util.Utility

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)
        val loadingImage = findViewById<LottieAnimationView>(R.id.splash_image)

        // 애니메이션 시작
        loadingImage.playAnimation()

        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            val intent = Intent(this, GoogleSignInPage::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}