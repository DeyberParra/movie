package com.deyber.movie.ui.dash.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.deyber.movie.R
import com.deyber.movie._utils.BaseViewHolder
import com.deyber.movie._utils.constants.RetrofitConstants
import com.deyber.movie._utils.extensions.typePoster
import com.deyber.movie.domain.model.ResultsMovieRated

class MovieRatedAdapter():RecyclerView.Adapter<MovieRatedAdapter.RatedHolder>() {

    private var movieRated: List<ResultsMovieRated> = listOf<ResultsMovieRated>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RatedHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rated_movie, parent, false)
        return RatedHolder(view)

    }

    fun loadData(list:List<ResultsMovieRated>){
        movieRated = list
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RatedHolder, position: Int) {

        itemCount.let { holder.bind(movieRated[position], position) }
    }

    override fun getItemCount()= movieRated.size

     inner class RatedHolder(itemView: View) : BaseViewHolder<ResultsMovieRated>(itemView){
         private var title:TextView
         private var rated:RatingBar
         private var img:ImageView

         init {
             title = itemView.findViewById(R.id.movie_title)
             rated = itemView.findViewById(R.id.movie_rated)
             img = itemView.findViewById(R.id.movie_poster)
         }

         override fun bind(item: ResultsMovieRated, position: Int ){
             title.text = item.title.toString()
             rated.apply {
                 rating =  (item.rating?.toFloat() ?: 0f)/2
             }
             img.typePoster(RetrofitConstants.urlThumb+item.posterPath)

         }
     }
}