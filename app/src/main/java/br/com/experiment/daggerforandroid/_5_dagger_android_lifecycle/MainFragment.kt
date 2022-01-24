package br.com.experiment.daggerforandroid._5_dagger_android_lifecycle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.experiment.daggerforandroid.databinding.MainFragmentBinding
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class MainFragment : Fragment() {

    @Inject
    protected lateinit var text: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return MainFragmentBinding.inflate(layoutInflater).apply {
            textview.text = text
        }.root
    }
}