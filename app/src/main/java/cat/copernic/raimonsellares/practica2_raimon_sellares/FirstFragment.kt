package cat.copernic.raimonsellares.practica2_raimon_sellares

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import cat.copernic.raimonsellares.practica2_raimon_sellares.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentFirstBinding =
                DataBindingUtil.inflate(inflater, R.layout.fragment_first, container, false)

        binding.buttonFirst.setOnClickListener() {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        return binding.root
    }

}