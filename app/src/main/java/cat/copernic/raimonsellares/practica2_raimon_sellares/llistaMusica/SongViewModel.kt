package cat.copernic.raimonsellares.practica2_raimon_sellares.llistaMusica

import android.util.Log
import androidx.lifecycle.ViewModel

class SongViewModel: ViewModel() {

    init {

        Log.i("SongViewModel", "SongViewModel created!")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("SongViewModel", "SongViewModel destroyed!")
    }
}