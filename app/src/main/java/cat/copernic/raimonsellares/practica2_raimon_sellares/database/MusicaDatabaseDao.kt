package cat.copernic.raimonsellares.practica2_raimon_sellares.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface MusicaDatabaseDao {

    @Insert
    suspend fun insert(musica: Musica)

    @Update
    suspend  fun update(musica: Musica)

    @Query("SELECT * from musica_taula WHERE id = :key")
    suspend fun get(key: Int): Musica?

    @Query("DELETE FROM musica_taula WHERE id = :keya")
    suspend fun delete(keya: Int)

    @Query("SELECT * FROM musica_taula ORDER BY id DESC")
    fun getAllNights(): LiveData<List<Musica>>

    @Query("SELECT * FROM musica_taula ORDER BY id DESC LIMIT 1")
    suspend fun getTonight(): Musica?
}
