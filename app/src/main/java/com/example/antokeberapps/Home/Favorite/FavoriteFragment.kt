package com.example.antokeberapps.Favorite

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.antokeberapps.Data.AppDatabase
import com.example.antokeberapps.Data.Entity.FavoriteNewsEntity
import com.example.antokeberapps.databinding.FragmentFavoriteBinding
import kotlinx.coroutines.launch

class FavoriteFragment : Fragment() {

    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!

    private lateinit var db: AppDatabase
    private lateinit var adapter: FavoriteAdapter
    private val favorites = mutableListOf<FavoriteNewsEntity>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        db = AppDatabase.getInstance(requireContext())

        adapter = FavoriteAdapter(favorites)
        binding.rvFavorite.layoutManager = LinearLayoutManager(requireContext())
        binding.rvFavorite.adapter = adapter

        fetchFavorite()
    }

    private fun fetchFavorite() {
        lifecycleScope.launch {
            val data = db.favoriteNewsDao().getAll()
            favorites.clear()
            favorites.addAll(data)
            adapter.notifyDataSetChanged()
        }
    }

    override fun onResume() {
        super.onResume()
        fetchFavorite()
    }
}