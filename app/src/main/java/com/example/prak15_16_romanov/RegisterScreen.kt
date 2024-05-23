package com.example.prak15_16_romanov

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class RegisterScreen : AppCompatActivity() {
    lateinit var log: EditText
    lateinit var pas: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_screen)
        log=findViewById(R.id.editText)
        pas=findViewById(R.id.editText2)
    }

    fun Enter(view: View) {
        if(log.text.toString().isNotEmpty()&&pas.text.toString().isNotEmpty()){
            val intent= Intent(this,Test::class.java)
            intent.getStringExtra(log.toString())
            startActivity(intent)
        }else
        {
            val alert= AlertDialog.Builder(this).setTitle("Error")
                .setMessage("Поля должны быть заполнены")
                .setPositiveButton("ok",null)
                .create()
                .show()
        }
    }
}