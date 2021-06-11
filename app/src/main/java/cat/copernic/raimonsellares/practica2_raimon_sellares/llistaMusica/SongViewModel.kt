package cat.copernic.raimonsellares.practica2_raimon_sellares.llistaMusica

import android.app.Application
import androidx.lifecycle.*
import cat.copernic.raimonsellares.practica2_raimon_sellares.database.Musica
import cat.copernic.raimonsellares.practica2_raimon_sellares.database.MusicaDatabaseDao
import kotlinx.coroutines.launch

class SongViewModel(val database: MusicaDatabaseDao,
                       application: Application
) : AndroidViewModel(application) {

    private var songs = database.getAllNights()
    lateinit var sonsRecycler: LiveData<List<Musica>>
    init {
        getAllSongs()
    }

    fun getAllSongs(): LiveData<List<Musica>> {
        viewModelScope.launch {
            songs = getAllSongs()
        }
        return songs
    }
    private suspend fun getAllSongsFromDatabase(): LiveData<List<Musica>> {
        return database.getAllNights()
    }

    fun getData(): LiveData<List<Musica>>  {
        viewModelScope.launch {
           sonsRecycler = getAllSongsFromDatabase()
        }
        return sonsRecycler
    }


}