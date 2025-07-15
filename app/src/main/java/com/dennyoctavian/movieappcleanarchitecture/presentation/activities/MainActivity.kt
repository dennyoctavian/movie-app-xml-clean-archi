package com.dennyoctavian.movieappcleanarchitecture.presentation.activities

import android.content.Intent
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
import com.dennyoctavian.movieappcleanarchitecture.databinding.ActivityMainBinding
import com.dennyoctavian.movieappcleanarchitecture.presentation.adapter.MovieAdapter
import com.dennyoctavian.movieappcleanarchitecture.presentation.viewmodels.ListMovieViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val listMovieViewModel: ListMovieViewModel by viewModels()
    private lateinit var adapter: MovieAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
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
                listMovieViewModel.movies.collect { movies ->
                    adapter = MovieAdapter(this@MainActivity,movies)
                    binding.rvMovieList.adapter = adapter
                }
            }
        }

        listMovieViewModel.getMovies()

        binding.fabFavorite.setOnClickListener {
            val intent = Intent(this@MainActivity, FavoriteActivity::class.java)
            startActivity(intent)
        }
    }
}