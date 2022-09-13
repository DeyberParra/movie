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
import com.deyber.movie.domain.model.ResultsMovie

class MovieAdapter():RecyclerView.Adapter<MovieAdapter.RatedHolder>() {

    private var list: List<ResultsMovie> = listOf<ResultsMovie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RatedHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rated_movie, parent, false)
        return RatedHolder(view)

    }

    fun loadData(list:List<ResultsMovie>){
        this.list = list
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RatedHolder, position: Int) {

        itemCount.let { holder.bind(list[position], position) }
    }

    override fun getItemCount()= list.size

     inner class RatedHolder(itemView: View) : BaseViewHolder<ResultsMovie>(itemView){
         private var title:TextView
         private var rated:RatingBar
         private var img:ImageView

         init {
             title = itemView.findViewById(R.id.movie_title)
             rated = itemView.findViewById(R.id.movie_rated)
             img = itemView.findViewById(R.id.movie_poster)
         }

         override fun bind(item: ResultsMovie, position: Int ){
             title.text = item.title.toString()
             rated.apply {
                 rating =  (item.voteAverage?.toFloat() ?: 0f)/2
             }
             img.typePoster(RetrofitConstants.urlThumb+item.posterPath)

         }
     }
}