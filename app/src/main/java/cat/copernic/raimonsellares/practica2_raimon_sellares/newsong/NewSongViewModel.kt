package cat.copernic.raimonsellares.practica2_raimon_sellares.newsong

import android.app.Application
import androidx.lifecycle.*
import cat.copernic.raimonsellares.practica2_raimon_sellares.database.Musica
import cat.copernic.raimonsellares.practica2_raimon_sellares.database.MusicaDatabaseDao
import kotlinx.coroutines.launch

class NewSongViewModel(
    val database: MusicaDatabaseDao,
    application: Application
) : AndroidViewModel(application) {

    private var musica = MutableLiveData<Musica?>()

    init {
        initializeTonight()
    }

    private fun initializeTonight() {
        viewModelScope.launch {
            musica.value = getTonightFromDatabase()
        }
    }

    private suspend fun getTonightFromDatabase(): Musica? {
        return database.getTonight()
    }

    fun getData(): Musica? {
        viewModelScope.launch {
            musica.value = getTonightFromDatabase()
        }
        return musica.value
    }

    private suspend fun insert(night: Musica) {
        database.insert(night)
    }

    fun onStartSong(music: Musica) {
        viewModelScope.launch {

            insert(music)

            musica.value = getTonightFromDatabase()
        }
    }

}