package cat.copernic.raimonsellares.practica2_raimon_sellares.newsong

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import cat.copernic.raimonsellares.practica2_raimon_sellares.database.MusicaDatabaseDao

class NewSongModelFactoryu(
    private val dataSource: MusicaDatabaseDao,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NewSongViewModel::class.java)) {
            return NewSongViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
