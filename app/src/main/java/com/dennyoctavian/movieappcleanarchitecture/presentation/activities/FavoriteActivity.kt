package com.dennyoctavian.movieappcleanarchitecture.presentation.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.dennyoctavian.movieappcleanarchitecture.R
import com.dennyoctavian.movieappcleanarchitecture.databinding.ActivityFavoriteBinding
import com.dennyoctavian.movieappcleanarchitecture.databinding.ActivityMainBinding
import com.dennyoctavian.movieappcleanarchitecture.presentation.adapter.MovieAdapter
import com.dennyoctavian.movieappcleanarchitecture.presentation.viewmodels.FavoriteViewModel
import com.dennyoctavian.movieappcleanarchitecture.presentation.viewmodels.ListMovieViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import kotlin.getValue

@AndroidEntryPoint
class FavoriteActivity : AppCompatActivity() {
    private val favoriteViewModel: FavoriteViewModel by viewModels()
    private lateinit var adapter: MovieAdapter
    private lateinit var binding: ActivityFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.rvMovieList.layoutManager = LinearLayoutManager(this)

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                favoriteViewModel.favorites.collect { favorites ->
                    adapter = MovieAdapter(this@FavoriteActivity,favorites)
                    binding.rvMovieList.adapter = adapter
                }
            }
        }
        favoriteViewModel.loadFavorites()
    }

    override fun onResume() {
        super.onResume()
        favoriteViewModel.loadFavorites()
    }
}