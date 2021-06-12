package cat.copernic.raimonsellares.practica2_raimon_sellares.newsong

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import cat.copernic.raimonsellares.practica2_raimon_sellares.R
import cat.copernic.raimonsellares.practica2_raimon_sellares.database.Musica
import cat.copernic.raimonsellares.practica2_raimon_sellares.database.MusicaDatabase
import cat.copernic.raimonsellares.practica2_raimon_sellares.databinding.FragmentNewSongBinding


class NewSongFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding: FragmentNewSongBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_new_song, container, false)


        val application = requireNotNull(this.activity).application

        // Create an instance of the ViewModel Factory.
        val dataSource = MusicaDatabase.getInstance(application).musicaDatabaseDao
        val viewModelFactory = NewSongModelFactoryu(dataSource, application)

        // Get a reference to the ViewModel associated with this fragment.
        val newSongViewModel =
            ViewModelProvider(
                this, viewModelFactory
            ).get(NewSongViewModel::class.java)


        binding.bttnDone.setOnClickListener {
            val song2 = binding.edTxtSong.text.toString()
            val artista2 = binding.edTxtArtista.text.toString()

            val musicEntity = Musica()
            musicEntity.song = song2
            musicEntity.artista = artista2

            newSongViewModel.onStartSong(musicEntity)
            val song = newSongViewModel.getData()?.artista
            if (song != null) {
                Log.i("insertddbb", song)
            }
            findNavController().navigate(R.id.action_newSongFragment_to_FirstFragment)

        }

        return binding.root
    }


}