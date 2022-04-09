package com.example.tp2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tp2.TodoRepository.Singleton.todoList


class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button:Button? = findViewById(R.id.bouton)
        val mon_recycler: RecyclerView? = findViewById(R.id.mon_recycler)

       val repo = TodoRepository()
        repo.updateData{
            mon_recycler?.layoutManager = LinearLayoutManager(this)
            mon_recycler?.adapter = TodoAdapter(todoList)
        }

        button?.setOnClickListener() {
            val intent = Intent(this, ActivityAddTodo::class.java)
            startActivity(intent)
        }
        

    }



    class TodoAdapter(
               private val elementAAfficher: List<Todo>
        ) : RecyclerView.Adapter<TodoAdapter.ViewHolder>() {

            class ViewHolder(val elementDeLaListe: View) : RecyclerView.ViewHolder(elementDeLaListe) {
               // val titre: EditText
                //val description: EditText
              //  val couleur: ImageView
                val todo_tv1: TextView? = elementDeLaListe.findViewById(R.id.todo_tv1)

                init {
                   // titre = elementDeLaListe.findViewById<EditText>(R.id.titre)
                   // description = elementDeLaListe.findViewById<EditText>(R.id.description)
                   // couleur = elementDeLaListe.findViewById<ImageView>(R.id.couleur)
                    //todo_tv1 = elementDeLaListe.findViewById(R.id.todo_tv1)
                }
              //  fun bind(todo: Todo){
               //     titre?.text = todo.titre as Editable
               //     description?.text = todo.description as Editable
                //}


            }

            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
                return ViewHolder(view)
            }

            override fun onBindViewHolder(holder: ViewHolder, position: Int) {

                val currentTodo= elementAAfficher[position]
                holder.todo_tv1?.text = currentTodo.titre + ": " + currentTodo.description

            }

            override fun getItemCount(): Int = elementAAfficher.size
        }

    }
