package cat.copernic.raimonsellares.practica2_raimon_sellares

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import cat.copernic.raimonsellares.practica2_raimon_sellares.databinding.FragmentNewSongBinding


class NewSongFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentNewSongBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_new_song, container, false)


        return binding.root
    }


}