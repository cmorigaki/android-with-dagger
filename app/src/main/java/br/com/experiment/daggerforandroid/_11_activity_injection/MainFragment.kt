package br.com.experiment.daggerforandroid._11_activity_injection

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import br.com.experiment.daggerforandroid.databinding.MainFragmentBinding
import javax.inject.Inject

class MainFragment @Inject constructor(
    private val text: String,
    private val applicationContext: Context,
    private val viewModelProviderFactory: ViewModelProvider.Factory,
) : Fragment() {

    private val viewModel by viewModels<MainViewModel>{ viewModelProviderFactory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return MainFragmentBinding.inflate(layoutInflater).apply {
            textview.text = text
        }.root
    }
}
