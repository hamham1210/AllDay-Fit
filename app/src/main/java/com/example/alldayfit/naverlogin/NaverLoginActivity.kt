package com.example.alldayfit.naverlogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.alldayfit.R
import com.example.alldayfit.databinding.NaverLoginActivityBinding
import com.navercorp.nid.NaverIdLoginSDK
import com.navercorp.nid.oauth.OAuthLoginCallback

class NaverLoginActivity : AppCompatActivity() {
    private lateinit var binding: NaverLoginActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = NaverLoginActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        NaverIdLoginSDK.initialize(this, "${R.string.naver_client_id}", "${R.string.naver_client_secret}", "${R.string.naver_client_name}")
        binding.buttonOAuthLoginImg.setOAuthLogin(object : OAuthLoginCallback {
            override fun onError(errorCode: Int, message: String) {
                Toast.makeText(applicationContext, "네이버 아이디 로그인 에러입니다. $message (오류코드: $errorCode)", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(httpStatus: Int, message: String) {
                Toast.makeText(applicationContext, "네이버 아이디 로그인 실패입니다. $message (오류코드: $httpStatus)", Toast.LENGTH_SHORT).show()
            }

            override fun onSuccess() {
                Toast.makeText(applicationContext, "네이버 아이디 로그인 성공입니다.", Toast.LENGTH_SHORT).show()
            }
        })
    }
}