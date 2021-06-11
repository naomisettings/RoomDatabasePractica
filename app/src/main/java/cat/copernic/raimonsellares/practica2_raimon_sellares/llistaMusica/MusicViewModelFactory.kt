package cat.copernic.raimonsellares.practica2_raimon_sellares.llistaMusica

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import cat.copernic.raimonsellares.practica2_raimon_sellares.database.MusicaDatabaseDao
import cat.copernic.raimonsellares.practica2_raimon_sellares.newsong.NewSongViewModel

class MusicViewModelFactory(
    private val dataSource: MusicaDatabaseDao,
    private val application: Application
) : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SongViewModel::class.java)) {
            return SongViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
