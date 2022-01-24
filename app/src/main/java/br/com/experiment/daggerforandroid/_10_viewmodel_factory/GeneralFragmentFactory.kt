package br.com.experiment.daggerforandroid._10_viewmodel_factory

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import javax.inject.Inject
import javax.inject.Provider

class GeneralFragmentFactory @Inject constructor(
    private val map: @JvmSuppressWildcards Map<Class<out Fragment>, Provider<Fragment>>,
) : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        val fragmentClass = loadFragmentClass(classLoader, className)
        return map[fragmentClass]?.get() ?: super.instantiate(classLoader, className)
    }
}