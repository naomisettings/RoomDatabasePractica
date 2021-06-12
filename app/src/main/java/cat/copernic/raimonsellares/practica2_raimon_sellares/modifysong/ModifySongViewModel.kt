package cat.copernic.raimonsellares.practica2_raimon_sellares.modifysong

import android.app.Application
import android.provider.SyncStateContract.Helpers.update
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import cat.copernic.raimonsellares.practica2_raimon_sellares.database.Musica
import cat.copernic.raimonsellares.practica2_raimon_sellares.database.MusicaDatabaseDao
import kotlinx.coroutines.launch

class ModifySongViewModel(
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

    private suspend fun update(night: Musica) {
        database.update(night)
    }

    fun onStartSong(music: Musica) {
        viewModelScope.launch {

            val oldNight = musica.value ?: return@launch

            oldNight.song = music.song
            oldNight.artista = music.artista

            update(oldNight)

           musica.value = getTonightFromDatabase()
        }
    }


    fun ondeletesong(key: Int) {
        viewModelScope.launch {
            database.delete(key) ?: return@launch

            musica.value = getTonightFromDatabase()
        }
    }


}