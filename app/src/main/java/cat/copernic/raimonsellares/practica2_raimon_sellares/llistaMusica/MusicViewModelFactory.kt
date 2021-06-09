package cat.copernic.raimonsellares.practica2_raimon_sellares.llistaMusica

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import cat.copernic.raimonsellares.practica2_raimon_sellares.database.MusicaDatabaseDao

class MusicViewModelFactory(
    private val songKey: Int,
    private val dataSource: MusicaDatabaseDao) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SongViewModel::class.java)) {
            return SongViewModel(songKey, dataSource) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}