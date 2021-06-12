package cat.copernic.raimonsellares.practica2_raimon_sellares.modifysong

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import cat.copernic.raimonsellares.practica2_raimon_sellares.R
import cat.copernic.raimonsellares.practica2_raimon_sellares.database.Musica
import cat.copernic.raimonsellares.practica2_raimon_sellares.database.MusicaDatabase
import cat.copernic.raimonsellares.practica2_raimon_sellares.databinding.FragmentSecondBinding
import cat.copernic.raimonsellares.practica2_raimon_sellares.newsong.NewSongModelFactoryu
import cat.copernic.raimonsellares.practica2_raimon_sellares.newsong.NewSongViewModel

class SecondFragment : Fragment() {

    private lateinit var args: SecondFragmentArgs

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {

        val binding: FragmentSecondBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_second, container, false)

        args = SecondFragmentArgs.fromBundle(requireArguments())

        val application = requireNotNull(this.activity).application

        // Create an instance of the ViewModel Factory.
        val dataSource = MusicaDatabase.getInstance(application).musicaDatabaseDao
        val viewModelFactory = ModifySongModelFactory(dataSource, application)

        // Get a reference to the ViewModel associated with this fragment.
        val modifySongViewModel =
            ViewModelProvider(
                this, viewModelFactory
            ).get(ModifySongViewModel::class.java)


        binding.editTextTextPersonName.setText(args.name)
        binding.editTextTextPersonName2.setText(args.artist)

        binding.bttnDoneModify.setOnClickListener {


            val musicEntity = Musica()
            musicEntity.song = binding.editTextTextPersonName.text.toString()
            musicEntity.artista = binding.editTextTextPersonName2.text.toString()
            Log.i("insertddbb2", musicEntity.song)

            modifySongViewModel.onStartSong(musicEntity)
            val song = modifySongViewModel.getData()?.artista
            if (song != null) {
                Log.i("insertddbb", song)
            }
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

        binding.buttonDelete.setOnClickListener {
            modifySongViewModel.ondeletesong(args.id)
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

        return binding.root
    }

}