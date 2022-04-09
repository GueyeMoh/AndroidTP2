package com.example.tp2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class ActivityAddTodo: AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_todo)
    }

        fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup,
            savedInstanceState: Bundle?
        ): View? {
            super.onCreate(savedInstanceState)
            val view = inflater?.inflate(R.layout.add_todo, container, false)
            val ajouter:Button? = view.findViewById(R.id.ajouter)
            val retour:ImageButton? = view.findViewById(R.id.arrow_back)
            //ajouter?.setOnClickListener (){ sendForm(view) }
          //  retour?.setOnClickListener(){ retour() }

            return view
        }

        private fun retour() {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }

        private fun sendForm(view: View) {
            val repo = TodoRepository()
            val titre = view.findViewById<EditText>(R.id.titre).text.toString()
            val description = view.findViewById<EditText>(R.id.description).text.toString()
            val todo = Todo(UUID.randomUUID().toString(), titre, description)
            if (todo != null) {
                repo.insertTodo(todo)
                startActivity(Intent(this, ActivityAddTodo::class.java))
            }

        }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.arrow_back -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            R.id.ajouter -> {
                sendForm(v)
            }
        }
    }

}