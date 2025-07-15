package com.dennyoctavian.movieappcleanarchitecture.presentation.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dennyoctavian.movieappcleanarchitecture.databinding.ItemMovieBinding
import com.dennyoctavian.movieappcleanarchitecture.domain.models.MovieEntity
import com.dennyoctavian.movieappcleanarchitecture.presentation.activities.DetailMovieActivity
import java.util.Locale

class MovieAdapter(private val context: Context, private val movies: List<MovieEntity>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    class MovieViewHolder(private val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieEntity) {
            Glide.with(binding.root.context)
                .load("https://image.tmdb.org/t/p/w500${movie.posterPath}")
                .centerCrop()
                .placeholder(android.R.color.darker_gray)
                .error(android.R.color.holo_red_dark)
                .into(binding.imageMovie)
            binding.nameMovie.text = movie.title
            binding.ratingFood.rating = (movie.voteAverage / 2).toFloat()
            binding.ratingNumber.text = String.format(Locale.US , "%.2f", movie.voteAverage / 2)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailMovieActivity::class.java)
            intent.putExtra("movie", movie)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = movies.size
}
