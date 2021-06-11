package cat.copernic.raimonsellares.practica2_raimon_sellares.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Musica::class], version = 1, exportSchema = false)
abstract class MusicaDatabase : RoomDatabase() {

    abstract val musicaDatabaseDao: MusicaDatabaseDao

    companion object {

        @Volatile
        private var INSTANCE: MusicaDatabase? = null

        fun getInstance(context: Context): MusicaDatabase {

            synchronized(this) {

                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MusicaDatabase::class.java,
                        "musica_taula"
                    )

                        .fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}
