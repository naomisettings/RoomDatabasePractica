package cat.copernic.raimonsellares.practica2_raimon_sellares.llistaMusica

import android.app.Application
import androidx.lifecycle.*
import cat.copernic.raimonsellares.practica2_raimon_sellares.database.Musica
import cat.copernic.raimonsellares.practica2_raimon_sellares.database.MusicaDatabase
import cat.copernic.raimonsellares.practica2_raimon_sellares.database.MusicaDatabaseDao
import kotlinx.coroutines.launch

class SongViewModel(val database: MusicaDatabaseDao,
                    application: Application
) : AndroidViewModel(application)  {

    var sonsRecycler: LiveData<List<Musica>>

    init {
        sonsRecycler = MutableLiveData()
    }
    init {
        initializeTonight()
    }

    private fun initializeTonight() {
        viewModelScope.launch {
            sonsRecycler = getSongsFromDatabase()
        }
    }

    private suspend fun getSongsFromDatabase(): LiveData<List<Musica>> {
        return database.getAllNights()
    }



/*
    //Per insertar, esborrar i actualitzar
    fun getAllSongsFromDatabase(): List<Musica>? {
        val songsDAO = MusicaDatabase.getInstance((getApplication())).musicaDatabaseDao
        sonsRecycler = songsDAO.getAllNights()

        return sonsRecycler

    }

 */


}