package com.aneeque.mvvm_app.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.aneeque.mvvm_app.R
import com.aneeque.mvvm_app.base.MyApp
import com.aneeque.mvvm_app.databinding.ActivityLoginBinding
import com.aneeque.mvvm_app.db.User

class Login : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initListeners()
    }

    private fun initListeners() {
        binding.btnSignIn.setOnClickListener(this)
        binding.btnSignUp.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btnSignIn -> {
                val username = binding.etUsername.text.toString()
                val password = binding.etPassword.text.toString()

                val user : User? = MyApp.roomDB.userDao().findByUsername(username)

                if ( null != user ) {
                    if (user.password == password) {
                        startActivity(Intent(this, MainActivity::class.java))
                        finish()
                    } else {
                        Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this, "User not found", Toast.LENGTH_SHORT).show()
                }
            }

            R.id.btnSignUp -> {
                startActivity(Intent(this, SignUp::class.java))
            }
        }
    }
}