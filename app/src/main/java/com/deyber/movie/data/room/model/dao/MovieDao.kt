package com.deyber.movie.data.room.model.dao

import androidx.room.*
import com.deyber.movie.data.room.model.ComingMovieEntity
import com.deyber.movie.data.room.model.PopularMovieEntity
import com.deyber.movie.data.room.model.TopRatedMovieEntity

import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Query("SELECT * FROM PopularMovie")
    fun getPopularMovie():Flow<List<PopularMovieEntity>>

    @Query("SELECT * FROM TopRatedMovie")
    fun getTopRatedMovie():Flow<List<TopRatedMovieEntity>>

    @Query("SELECT * FROM ComingMovie")
    fun getComingMovie():Flow<List<ComingMovieEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun savePopularMovie(popularMovie:PopularMovieEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTopRatedMovie(topRatedMovie:TopRatedMovieEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveComingMovie(comingMovie: ComingMovieEntity)

    @Query("DELETE FROM PopularMovie")
    suspend fun deletPoularMovie()

    @Query("DELETE FROM TopRatedMovie")
    suspend fun deletTopRatedMovie()

    @Query("DELETE FROM ComingMovie")
    suspend fun deletComingMovie()
}