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
import cat.copernic.raimonsellares.practica2_raimon_sellares.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentSecondBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_second, container, false)

        binding.buttonSecond.setOnClickListener() {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

        return binding.root
    }

}