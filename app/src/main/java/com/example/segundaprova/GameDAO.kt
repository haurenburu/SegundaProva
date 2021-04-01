package com.example.segundaprova

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
    @Query("SELECT * FROM game")
    fun findGame(id: Long): Array<Game>
    // listar por ID
    @Query("SELECT * FROM game WHERE id = :id")
    fun findById(id: Long): Game
    // excluir
    @Delete
    fun delete(game: Game): Int
}
