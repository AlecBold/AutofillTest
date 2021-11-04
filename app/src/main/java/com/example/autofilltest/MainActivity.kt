package com.example.autofilltest

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.autofill.AutofillManager
import android.widget.Button
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

  private lateinit var email: AppCompatEditText
  private lateinit var password: AppCompatEditText

//  private lateinit var emailContainer: TextInputLayout
//  private lateinit var passwordContainer: TextInputLayout

  private lateinit var btnLogIn: Button

  private lateinit var error: AppCompatTextView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    email = findViewById(R.id.email)
    password = findViewById(R.id.password)

//    emailContainer = findViewById(R.id.email_container)
//    passwordContainer = findViewById(R.id.password_container)

    btnLogIn = findViewById(R.id.btn_log_in)

    error = findViewById(R.id.error_auth)

    initListeners()
  }

  private fun initListeners() {
    email.addTextChangedListener(object: TextWatcher {
      override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
      }

      override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        if (isLoginValid(s)) {
          if (!password.isVisible) {
            password.visibility = VISIBLE
          }
        } else {
          if (password.isVisible) {
            password.visibility = GONE
          }
        }
      }

      override fun afterTextChanged(s: Editable?) {
      }

    })

    btnLogIn.setOnClickListener {
      if (isAuthAcceptable()) {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O) {
          val afm = getSystemService(AutofillManager::class.java)
          afm.commit()
        }
        error.visibility = GONE
      } else {
        error.visibility = VISIBLE
      }
    }
  }

  fun isAuthAcceptable(): Boolean {
    return isLoginValid(email.text) && !password.text.isNullOrEmpty()
  }

  fun isLoginValid(s: CharSequence?): Boolean {
    if (s == null) return false
    if (s.length > 5 && s.contains("@")) return true
    return false
  }
}