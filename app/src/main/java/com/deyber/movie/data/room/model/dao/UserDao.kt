package com.deyber.movie.data.room.model.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.deyber.movie.data.room.model.UserEntity
import com.deyber.movie.data.room.model.UserMovieRatedEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface UserDao {

    @Query("SELECT * FROM User LIMIT 1")
    suspend fun geUser(): UserEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun newUser(user:UserEntity)

    @Query("DELETE  FROM User")
    suspend fun deleteAllUser()

    //con funciones flow

    @Query("SELECT * FROM User LIMIT 1")
    fun getUser(): Flow<UserEntity>

    @Query("SELECT * FROM UserMovieRated")
    fun getUserMovieRated():Flow<List<UserMovieRatedEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveUserMoviesRated(UsermoviesRated:UserMovieRatedEntity)

    @Query("DELETE FROM UserMovieRated")
    suspend fun deleteAllUserMovieRated()

}