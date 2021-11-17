package com.facronactz.warman

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    var database = Firebase.database("https://warman-f2321-default-rtdb.asia-southeast1.firebasedatabase.app/")

    fun basicReadWrite(view: View) {
        // [START write_message]
        // Write a message to the database
        val input = findViewById<EditText>(R.id.editText)
        val inputtoDB = input.text.toString()


        val myRef = database.getReference("Restaurant")
        myRef.child(inputtoDB).setValue(inputtoDB)

        myRef.child(inputtoDB).get().addOnSuccessListener {
            Toast.makeText(this, "${it.value}", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener{
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
        }
    }

    fun readDB(view: View) {
        val input = findViewById<EditText>(R.id.editText)
        val inputtoDB = input.text.toString()

        val myRef = database.getReference("Restaurant")

        myRef.child(inputtoDB).get().addOnSuccessListener {
            Toast.makeText(this, "${it.value}", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener{
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
        }
    }


    fun conto(){
        myRef.child(Restaurant).child(Menu).child(Menu).getValue(Harga)
        ReadDB(Restaurant, Menu, Nama)
    }
}