package cat.copernic.raimonsellares.practica2_raimon_sellares.database

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "musica_taula")
data class Musica(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @ColumnInfo(name = "nom")
    var song: String = "",

    @ColumnInfo(name = "artista")
    var artista: String = "",

    ):Parcelable