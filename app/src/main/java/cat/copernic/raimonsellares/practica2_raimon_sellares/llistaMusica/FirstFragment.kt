package cat.copernic.raimonsellares.practica2_raimon_sellares.llistaMusica

import android.os.Bundle
import android.util.Log
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
import cat.copernic.raimonsellares.practica2_raimon_sellares.database.Musica
import cat.copernic.raimonsellares.practica2_raimon_sellares.database.MusicaDatabase
import cat.copernic.raimonsellares.practica2_raimon_sellares.database.MusicaDatabaseDao
import cat.copernic.raimonsellares.practica2_raimon_sellares.databinding.FragmentFirstBinding
import cat.copernic.raimonsellares.practica2_raimon_sellares.newsong.NewSongModelFactoryu
import cat.copernic.raimonsellares.practica2_raimon_sellares.newsong.NewSongViewModel
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

        // Create an instance of the ViewModel Factory.
        val dataSource = MusicaDatabase.getInstance(application).musicaDatabaseDao
        val viewModelFactory = MusicViewModelFactory(dataSource, application)

        // Get a reference to the ViewModel associated with this fragment.
        val musicViewModel =
            ViewModelProvider(
                this, viewModelFactory
            ).get(SongViewModel::class.java)


        binding.fab.setOnClickListener {
                findNavController().navigate(R.id.action_FirstFragment_to_newSongFragment)
        }

        musicViewModel.getAllSongs().observeForever{
        Log.d("sonsobserve", it[0].song)
           val adapter = SongsAdapter(
                it as MutableList<Musica>,
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

        return binding.root
    }
}

