package cat.copernic.raimonsellares.practica2_raimon_sellares.llistaMusica

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cat.copernic.raimonsellares.practica2_raimon_sellares.R
import cat.copernic.raimonsellares.practica2_raimon_sellares.database.MusicaDatabase
import cat.copernic.raimonsellares.practica2_raimon_sellares.databinding.FragmentFirstBinding
import java.util.*

class FirstFragment : Fragment() {

    private lateinit var rvSongs: RecyclerView

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {

        val binding: FragmentFirstBinding =
                DataBindingUtil.inflate(inflater, R.layout.fragment_first, container, false)

        val application = requireNotNull(this.activity).application
        val arguments = FirstFragmentArgs.fromBundle(requireArguments())

        // Create an instance of the ViewModel Factory.
        val dataSource = MusicaDatabase.getInstance(application).musicaDatabaseDao
        val viewModelFactory = MusicViewModelFactory(arguments.id, dataSource)

        // Get a reference to the ViewModel associated with this fragment.
        val songViewModel =
            ViewModelProvider(
                this, viewModelFactory).get(SongViewModel::class.java)


        binding.fab.setOnClickListener {
                findNavController().navigate(R.id.action_FirstFragment_to_newSongFragment)
        }


        return binding.root
    }

    private fun showSongs(rvSongs: RecyclerView){

        val s1 = Song(name = "nom", artist = "artista")
        val s2 = Song(name = "nom2", artist = "artista2")
        val s3 = Song(name = "nom3", artist = "artista3")
        val songs: MutableList<Song> = mutableListOf(s1, s2, s3)

        val adapter = SongsAdapter(
            songs as ArrayList<Song>,
            CellClickListener { name, artist ->
                view?.findNavController()
                    ?.navigate(
                        FirstFragmentDirections
                            .actionFirstFragmentToSecondFragment(
                                name,
                                artist,
                                id
                            )
                    )
            })

        rvSongs.adapter = adapter
        rvSongs.layoutManager = LinearLayoutManager(this.context)
    }
}

