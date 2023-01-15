package com.example.project_akhir_mobile

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.project_akhir_mobile.databinding.RegisterBinding
import com.google.firebase.auth.FirebaseAuth

class activity_register:AppCompatActivity() {

    lateinit var binding: RegisterBinding
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = RegisterBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()



        binding.btnSignUp.setOnClickListener {
            val email = binding.Email.text.toString()
            val password = binding.Password.text.toString()



            if (email.isEmpty()) {
                binding.Email.error = "Isi lah Email nya"
                binding.Email.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.Email.error = "Diisi Dulu loh"
                binding.Email.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                binding.Password.error = "Isi Password"
                binding.Password.requestFocus()
                return@setOnClickListener
            }

            if (password.length < 5) {
                binding.Password.error = "Password Minimal 5 Karakter"
                binding.Password.requestFocus()
                return@setOnClickListener
            }

            RegisterFirebase(email,password)

        }

    }

    private fun RegisterFirebase(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener(this){
                if (it.isSuccessful){
                    Toast.makeText(this, "Alhamdulillah  Berhasil", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this,activity_login::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }
}

