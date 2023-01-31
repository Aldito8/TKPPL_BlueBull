package com.example.fafafapet

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fafafapet.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity() {

    lateinit var auth: FirebaseAuth
    lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.TxtMasuk.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        auth = FirebaseAuth.getInstance()

        binding.btnDaftar.setOnClickListener{
            val email = binding.EdtTxtEmail2.text.toString()
            val password = binding.EdtTxtKataSandi2.text.toString()
            val kfrmpassword = binding.edtTxtKataSandi3.text.toString()

            if(email.isEmpty()){
                binding.EdtTxtEmail2.error = "email harus diisi"
                binding.EdtTxtEmail2.requestFocus()
                return@setOnClickListener
            }

            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.EdtTxtEmail2.error = "email tidak valid"
                binding.EdtTxtEmail2.requestFocus()
                return@setOnClickListener
            }

            if(password.isEmpty()){
                binding.EdtTxtKataSandi2.error = "kata sandi harus diisi"
                binding.EdtTxtKataSandi2.requestFocus()
                return@setOnClickListener
            }

            if (password.length < 5){
                binding.EdtTxtKataSandi2.error = "kata sandi minimal 5 karakter"
                binding.EdtTxtKataSandi2.requestFocus()
                return@setOnClickListener
            }

            if (kfrmpassword.isEmpty()){
                binding.edtTxtKataSandi3.error = "konfirmasi kata sandi anda"
                binding.edtTxtKataSandi3.requestFocus()
                return@setOnClickListener
            }

            if (kfrmpassword != password){
                binding.edtTxtKataSandi3.error = "kata sandi tidak valid"
                binding.edtTxtKataSandi3.requestFocus()
                return@setOnClickListener
            }

            RegisterFirebase(email, password)
        }
    }

    private fun RegisterFirebase(email: String, password: String){
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this){
                if(it.isSuccessful){
                    Toast.makeText(this, "Akun berhasil didaftar", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(this, "Akun gagal didaftar", Toast.LENGTH_SHORT).show()
                }
            }
    }
}
