package com.facronactz.warman

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    var database = Firebase.database

    fun basicReadWrite(view: View) {
        val inputPK = findViewById<EditText>(R.id.PK).text.toString()
        val inputAttr = findViewById<EditText>(R.id.attr)
        val inputtoDB = inputAttr.text.toString()


        val myRef = database.getReference("Restaurant")
        myRef.child(inputPK).setValue(inputtoDB)

        myRef.child(inputPK).get().addOnSuccessListener {
            Toast.makeText(this, "${it.value}", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener{
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
        }
    }

    fun readDB(view: View) {
        val input = findViewById<EditText>(R.id.attr)
        val inputtoDB = input.text.toString()

        val myRef = database.getReference("Restaurant")

        myRef.child(inputtoDB).get().addOnSuccessListener {
            Toast.makeText(this, "${it.value}", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener{
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
        }
    }
}