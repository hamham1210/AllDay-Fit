package com.example.alldayfit.login.twitter

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.alldayfit.databinding.SignInPageActivityBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.TwitterAuthProvider
import com.twitter.sdk.android.core.Callback
import com.twitter.sdk.android.core.Result
import com.twitter.sdk.android.core.TwitterException
import com.twitter.sdk.android.core.TwitterSession
import com.twitter.sdk.android.core.identity.TwitterAuthClient


class TwitterSignIn : AppCompatActivity() {
    private lateinit var binding: SignInPageActivityBinding
    private lateinit var twitterAuthClient: TwitterAuthClient
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SignInPageActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.twitterSignIn.setOnClickListener{
            twitterLogin()

        }

    }
    private fun twitterLogin() {
        twitterAuthClient.authorize(this,object : Callback<TwitterSession>(){
            override fun success(result: Result<TwitterSession>?) {
                val credential = TwitterAuthProvider.getCredential(
                    result?.data?.authToken?.token!!,
                    result.data?.authToken?.secret!!
                )

                auth.signInWithCredential(credential)
                    .addOnCompleteListener(this@TwitterSignIn){task ->
                        if (task.isSuccessful){
                            val user =auth.currentUser
                            Toast.makeText(
                                this@TwitterSignIn,
                                "로그인 성공 : ${user?.displayName}}",Toast.LENGTH_SHORT
                            ).show()
                        }else{
                            Toast.makeText(
                                    this@TwitterSignIn,
                                "로그인 실패 : ${task.exception?.message}",
                                Toast.LENGTH_SHORT).show()
                        }
                    }
            }

            override fun failure(exception: TwitterException?) {
                Toast.makeText(
                    this@TwitterSignIn,
                    "트위터 로그인 실패. ${exception?.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        twitterAuthClient.onActivityResult(resultCode,resultCode, data)
    }

}