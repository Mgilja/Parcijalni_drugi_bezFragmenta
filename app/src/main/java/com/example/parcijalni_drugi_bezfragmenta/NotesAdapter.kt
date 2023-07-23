package com.example.parcijalni_drugi_bezfragmenta

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesAdapter(val notesList:List<Note>, val deleteNote:(Int) -> Unit):
    RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {

    inner class NoteViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val textNoteTitle:TextView = itemView.findViewById(R.id.textNoteTitle)
        val textNoteDetails:TextView = itemView.findViewById(R.id.textNoteDetails)
        val buttonDelete: Button = itemView.findViewById(R.id.buttonDelete)

         init {
             buttonDelete.setOnClickListener {
                 deleteNote(adapterPosition)


             }
         }



    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.note, parent, false)

        return NoteViewHolder(itemView)
    }

    override fun getItemCount(): Int = notesList.size


    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {

        val currentNote = notesList[position]
        holder.textNoteTitle.text = currentNote.title
        holder.textNoteDetails.text = currentNote.details



    }
}