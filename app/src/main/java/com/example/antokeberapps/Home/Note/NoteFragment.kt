package com.example.antokeberapps.Note

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.antokeberapps.Data.AppDatabase
import com.example.antokeberapps.Data.Entity.NoteEntity
import com.example.antokeberapps.Home.Note.NoteFormActivity
import com.example.antokeberapps.databinding.FragmentNoteBinding
import kotlinx.coroutines.launch

class NoteFragment : Fragment() {

    private var _binding: FragmentNoteBinding? = null
    private val binding get() = _binding!!

    private lateinit var db: AppDatabase
    private lateinit var adapter: NoteAdapter
    private val notes = mutableListOf<NoteEntity>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        db = AppDatabase.getInstance(requireContext())

        adapter = NoteAdapter(notes)
        binding.rvNotes.layoutManager = LinearLayoutManager(requireContext())
        binding.rvNotes.adapter = adapter

        binding.fabAddNote.setOnClickListener {
            startActivity(Intent(requireContext(), NoteFormActivity::class.java))
        }

        fetchNotes()
    }

    private fun fetchNotes() {
        lifecycleScope.launch {
            val data = db.noteDao().getAll()
            notes.clear()
            notes.addAll(data)
            adapter.notifyDataSetChanged()
        }
    }

    override fun onResume() {
        super.onResume()
        fetchNotes()
    }
}