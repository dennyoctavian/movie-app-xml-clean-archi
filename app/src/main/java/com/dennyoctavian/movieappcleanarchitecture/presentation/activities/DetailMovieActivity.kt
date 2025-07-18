package com.dennyoctavian.movieappcleanarchitecture.presentation.activities

import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.bumptech.glide.Glide
import com.dennyoctavian.movieappcleanarchitecture.R
import com.dennyoctavian.movieappcleanarchitecture.databinding.ActivityDetailMovieBinding
import com.dennyoctavian.core.domain.models.MovieEntity
import com.dennyoctavian.core.presentation.viewmodels.DetailMovieViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.util.Locale

@AndroidEntryPoint
class DetailMovieActivity : AppCompatActivity() {
    private val detailMovieViewModel: DetailMovieViewModel by viewModels()
    private lateinit var binding: ActivityDetailMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val movie: MovieEntity? = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("movie", MovieEntity::class.java)
        } else {
            intent.getParcelableExtra("movie")
        }

        detailMovieViewModel.getDetailMovie(movie?.id)
        detailMovieViewModel.checkFavorite(movie?.id)

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                detailMovieViewModel.movie.collect { movieDetail ->
                    movieDetail?.let {
                        Glide.with(this@DetailMovieActivity)
                            .load("https://image.tmdb.org/t/p/w500${it.posterPath}")
                            .centerCrop()
                            .into(binding.ivMoviePhoto)
                        binding.tvMovieName.text = it.title
                        binding.tvMovieDescription.text = it.overview
                        binding.tvMovieCountry.text = it.originCountry.joinToString(", ")
                        binding.ratingFood.rating = (it.voteAverage / 2).toFloat()
                        binding.ratingNumber.text = String.format(Locale.US , "%.2f", it.voteAverage / 2)
                    }
                }
            }
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                detailMovieViewModel.isFavorite.collect { isFavorite ->
                    if (isFavorite) {
                        binding.saveDeleteText.text = "Delete Movie"
                        binding.loveIcon.setImageResource(R.drawable.ic_heart)
                    } else {
                        binding.saveDeleteText.text = "Save Movie"
                        binding.loveIcon.setImageResource(R.drawable.ic_heart_outlined)
                    }
                }
            }
        }

        binding.saveDeleteText.setOnClickListener {
            movie?.let {
                if (detailMovieViewModel.isFavorite.value) {
                    detailMovieViewModel.removeFavorites(it)
                } else {
                    detailMovieViewModel.addFavorites(it)
                }
            }

        }

        binding.loveIcon.setOnClickListener {
            movie?.let {
                if (detailMovieViewModel.isFavorite.value) {
                    detailMovieViewModel.removeFavorites(it)
                } else {
                    detailMovieViewModel.addFavorites(it)
                }
            }

        }

    }
}