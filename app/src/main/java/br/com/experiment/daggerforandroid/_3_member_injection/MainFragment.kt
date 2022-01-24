package br.com.experiment.daggerforandroid._3_member_injection

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.experiment.daggerforandroid.databinding.MainFragmentBinding
import javax.inject.Inject

class MainFragment : Fragment() {

    @Inject
    protected lateinit var text: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireContext().applicationContext as MainApplication).component.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return MainFragmentBinding.inflate(layoutInflater).apply {
            textview.text = text
        }.root
    }
}