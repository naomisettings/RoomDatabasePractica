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
import cat.copernic.raimonsellares.practica2_raimon_sellares.databinding.FragmentFirstBinding
import java.util.*

class FirstFragment : Fragment() {

    private lateinit var viewModel: SongViewModel

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentFirstBinding =
                DataBindingUtil.inflate(inflater, R.layout.fragment_first, container, false)

        viewModel = ViewModelProvider(this).get(SongViewModel::class.java)

        var rvSongs = binding.rvSongs
        showSongs(rvSongs)

        binding.fab.setOnClickListener() {
                findNavController().navigate(R.id.action_FirstFragment_to_newSongFragment)
        }


        return binding.root
    }

    fun showSongs(rvSongs: RecyclerView){

        val s1 = Song(name = "nom", artist = "artista")
        val s2 = Song(name = "nom2", artist = "artista2")
        val s3 = Song(name = "nom3", artist = "artista3")
        var songs: MutableList<Song> = mutableListOf(s1, s2, s3)

        val adapter = SongsAdapter(
            songs as ArrayList<Song>,
            CellClickListener { name, artist ->
                view?.findNavController()
                    ?.navigate(
                        FirstFragmentDirections
                            .actionFirstFragmentToSecondFragment(
                                name,
                                artist
                            )
                    )
            })

        rvSongs.adapter = adapter
        rvSongs.layoutManager = LinearLayoutManager(this.context)
    }
}

