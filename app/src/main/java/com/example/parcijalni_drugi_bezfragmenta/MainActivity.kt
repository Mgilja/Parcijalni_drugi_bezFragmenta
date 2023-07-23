package com.example.parcijalni_drugi_bezfragmenta

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recylerView:RecyclerView
    private lateinit var notesAdapter: NotesAdapter

    private val notesList = mutableListOf<Note>()

    private lateinit var editTextTitle:EditText
    private lateinit var  editTextDetails: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recylerView = findViewById(R.id.recyclerView)
        notesAdapter = NotesAdapter(notesList) { position ->
            notesList.removeAt(position)
            notesAdapter.notifyDataSetChanged()
        }
        recylerView.layoutManager = LinearLayoutManager(this)
        recylerView.adapter = notesAdapter

        editTextTitle = findViewById(R.id.editTextTitle)
        editTextDetails = findViewById(R.id.editTextDetails)

        val buttonSave = findViewById<Button>(R.id.buttonSave)
        buttonSave.setOnClickListener{
            val title = editTextTitle.text.toString()
            val details = editTextDetails.text.toString()

            if(title.isNotBlank() && details.isNotBlank()) {
                val note = Note(title, details)
                notesList.add(note)
                notesAdapter.notifyDataSetChanged()

                editTextTitle.text.clear()
                editTextDetails.text.clear()

                val text = "Successfully added"
                val length = Toast.LENGTH_SHORT
                val toast = Toast.makeText(this, text, length)
                toast.show()
            }
             else {

                 if(title.isBlank()) {
                     editTextTitle.error = "Enter the note title"
                 }
                if(details.isBlank()) {
                    editTextDetails.error = "Enter the notes details"
                }
                val text = "Seomthing is empty, please double check it"
                val length = Toast.LENGTH_SHORT
                val toast = Toast.makeText(this, text, length)
                toast.show()

            }


        }


    }
}