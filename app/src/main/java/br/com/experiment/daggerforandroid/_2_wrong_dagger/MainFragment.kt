package br.com.experiment.daggerforandroid._2_wrong_dagger

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.experiment.daggerforandroid.databinding.MainFragmentBinding
import javax.inject.Inject

class MainFragment @Inject constructor(
    private val text: String,
) : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return MainFragmentBinding.inflate(layoutInflater).apply {
            textview.text = text
        }.root
    }
}