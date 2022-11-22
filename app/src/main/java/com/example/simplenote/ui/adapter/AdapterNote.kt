package com.example.simplenote.ui.adapter

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.simplenote.R
import com.example.simplenote.data.local.entity.NoteEntity
import com.example.simplenote.databinding.ItemHomeBinding
import com.example.simplenote.ui.home.HomeViewModel
import com.example.simplenote.ui.home.HomeViewModelFactory
import com.example.simplenote.ui.update.UpdateFragment

class AdapterNote(val viewModel: HomeViewModel) : ListAdapter<NoteEntity, AdapterNote.NoteViewHolder>(Diffcallback) {

    inner class NoteViewHolder(private val binding: ItemHomeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindView(note: NoteEntity) {
            binding.tvItemTitle.text = note.title
            binding.tvItemDesc.text = note.description

            binding.root.setOnClickListener {
                val bundle = bundleOf("myNote" to note)
                it.findNavController().navigate(R.id.action_homeFragment_to_updateFragment, bundle)
            }


            binding.root.setOnLongClickListener {
                val builder : AlertDialog.Builder = AlertDialog.Builder(it.context)
                builder.setMessage("Do you want to delete this note?")
                builder.setTitle("Delete!")
                builder.setCancelable(false)
                builder.setPositiveButton("Delete", (DialogInterface.OnClickListener { dialogInterface, i ->
                    viewModel.doDelete(note)
                }))

                builder.setNegativeButton("Cancel", (DialogInterface.OnClickListener { dialogInterface, i ->
                    dialogInterface.cancel()
                }))

                val alertDialog: Unit = builder.create().show()
                true
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return NoteViewHolder(ItemHomeBinding.inflate(layoutInflater,parent,false))
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bindView(getItem(position))
    }

    companion object{
        private val Diffcallback = object  : DiffUtil.ItemCallback<NoteEntity>(){
            override fun areItemsTheSame(oldItem: NoteEntity, newItem: NoteEntity): Boolean {
                return oldItem.id == newItem.id
            }
            override fun areContentsTheSame(oldItem: NoteEntity, newItem: NoteEntity): Boolean {
                return oldItem == newItem
            }
        }
    }


}




