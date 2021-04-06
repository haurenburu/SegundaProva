package com.example.segundaprova

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface GameDAO {
    // cadastrar
    @Insert
    fun insert(game: Game): Long
    // editar
    @Update
    fun update(game: Game): Int
    // listar todos
    @Query("SELECT * FROM game_table")
    fun listAll(): LiveData<List<Game>>
    // listar por ID
    @Query("SELECT * FROM game_table WHERE id = :id")
    fun findById(id: Long): Game
    // excluir
    @Delete
    fun delete(game: Game): Int
}
