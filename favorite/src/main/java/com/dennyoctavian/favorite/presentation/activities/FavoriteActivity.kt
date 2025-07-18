package com.dennyoctavian.favorite.presentation.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.dennyoctavian.core.presentation.di.FavoriteModuleDependencies
import com.dennyoctavian.core.presentation.viewmodels.FavoriteViewModel
import com.dennyoctavian.core.presentation.viewmodels.FavoriteViewModelFactory
import com.dennyoctavian.movieappcleanarchitecture.R
import com.dennyoctavian.movieappcleanarchitecture.databinding.ActivityFavoriteBinding
import com.dennyoctavian.movieappcleanarchitecture.presentation.adapter.MovieAdapter
import dagger.hilt.android.EntryPointAccessors
import kotlinx.coroutines.launch

class FavoriteActivity : AppCompatActivity() {
    private lateinit var favoriteViewModel: FavoriteViewModel
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
        val entryPoint = EntryPointAccessors.fromApplication(
            applicationContext,
            FavoriteModuleDependencies::class.java
        )

        val factory = FavoriteViewModelFactory(entryPoint.getFavoriteMoviesUseCase())
        favoriteViewModel = ViewModelProvider(this, factory)[FavoriteViewModel::class.java]
        binding.rvMovieList.layoutManager = LinearLayoutManager(this)

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                favoriteViewModel.favorites.collect { favorites ->
                    adapter = MovieAdapter(this@FavoriteActivity, favorites)
                    binding.rvMovieList.adapter = adapter
                }
            }
        }
        favoriteViewModel.loadFavorites()
    }

    override fun onResume() {
        favoriteViewModel.loadFavorites()
        super.onResume()
    }
}
