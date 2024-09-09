package com.aneeque.mvvm_app.ui

import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.aneeque.mvvm_app.R
import com.aneeque.mvvm_app.base.MyApp
import com.aneeque.mvvm_app.databinding.ActivitySignUpBinding
import com.aneeque.mvvm_app.db.User

class SignUp : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initListeners()
    }


    private fun initListeners() {
        binding.btnSignUp.setOnClickListener(this)
        binding.btnBack.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btnSignUp -> {
                val email = binding.etEmail.text.toString()
                val username = binding.etUsername.text.toString()
                val password = binding.etPassword.text.toString()
                if (email.isNotEmpty() && !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(this, "Enter valid email address", Toast.LENGTH_SHORT).show();
                } else {
                    val numberOfUsers = MyApp.roomDB.userDao().getAll().size + 1
                    val newUser =
                        User(numberOfUsers, email = email, username = username, password = password)
                    MyApp.roomDB.userDao().insertUser(newUser)
                    Toast.makeText(this, "User added to database", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }

            R.id.btnBack -> {
                finish()
            }
        }
    }
}