package br.com.experiment.daggerforandroid._7_fragment_factory_map

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import javax.inject.Inject
import javax.inject.Provider

class GeneralFragmentFactory @Inject constructor(
    private val map: @JvmSuppressWildcards Map<String, Provider<Fragment>>,
) : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return map[className]?.get() ?: super.instantiate(classLoader, className)
    }
}