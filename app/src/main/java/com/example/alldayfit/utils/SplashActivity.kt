package com.example.alldayfit.utils

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.alldayfit.databinding.SplashActivityBinding
import com.example.alldayfit.settings.login.GoogleSignInPage

class SplashActivity : AppCompatActivity() {
    private lateinit var splashScreen: SplashScreen
    private lateinit var binding : SplashActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SplashActivityBinding.inflate(layoutInflater)
        splashScreen = installSplashScreen()
        setContentView(binding.root)
        binding.splashImage.playAnimation()

        val handler = Handler()
        handler.postDelayed({
            val intent = Intent(this, GoogleSignInPage::class.java)
            startActivity(intent)
            finish()
        }, 1000)
    }
}