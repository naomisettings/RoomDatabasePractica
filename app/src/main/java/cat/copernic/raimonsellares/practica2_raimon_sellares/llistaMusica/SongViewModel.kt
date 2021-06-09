package cat.copernic.raimonsellares.practica2_raimon_sellares.llistaMusica

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cat.copernic.raimonsellares.practica2_raimon_sellares.database.MusicaDatabaseDao
import kotlinx.coroutines.launch

class SongViewModel(
    private val musicaKey: Int = 0,
    val database: MusicaDatabaseDao
) : ViewModel() {

    private val _navegarSong = MutableLiveData<Boolean?>()

    val navegarSong: LiveData<Boolean?>
        get() = _navegarSong

    fun doneNavigating() {
        _navegarSong.value = null
    }
    fun modificarMusicaQuality(quality: Int) {
        viewModelScope.launch {
            val tonight = database.get(musicaKey) ?: return@launch
           // tonight.quality = quality
           // database.update(tonight)

            _navegarSong.value = true
        }
    }

}