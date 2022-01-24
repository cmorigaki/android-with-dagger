package br.com.experiment.daggerforandroid._6_fragment_factory_simple

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import javax.inject.Inject
import javax.inject.Provider

class MainFragmentFactory @Inject constructor(
    private val fragmentProvider: Provider<MainFragment>
) : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        if (className == MainFragment::class.java.name) {
            return fragmentProvider.get()
        }
        return super.instantiate(classLoader, className)
    }
}