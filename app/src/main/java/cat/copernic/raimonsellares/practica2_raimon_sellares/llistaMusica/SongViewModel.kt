package cat.copernic.raimonsellares.practica2_raimon_sellares.llistaMusica

import android.app.Application
import androidx.lifecycle.*
import cat.copernic.raimonsellares.practica2_raimon_sellares.database.Musica
import cat.copernic.raimonsellares.practica2_raimon_sellares.database.MusicaDatabaseDao
import kotlinx.coroutines.launch
import java.nio.file.Files.delete

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

    private fun getSongsFromDatabase(): LiveData<List<Musica>> {
        return database.getAllNights()
    }

    private suspend fun deleteAll() {
        database.deleteAll()
    }

    fun deleteAllFromDatabase(){
        viewModelScope.launch {
            deleteAll()
        }
    }
}