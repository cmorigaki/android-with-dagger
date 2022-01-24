package br.com.experiment.daggerforandroid._7_fragment_factory_map.di

import androidx.fragment.app.Fragment
import br.com.experiment.daggerforandroid._7_fragment_factory_map.MainFragment
import br.com.experiment.daggerforandroid._7_fragment_factory_map.GeneralFragmentFactory
import dagger.*
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Component(
    modules = [MainModule::class, FragmentModule::class]
)
interface MainComponent {
    fun getFragmentFactory(): GeneralFragmentFactory
}

@Module
object MainModule {
    @Provides
    fun provideText(): String = "Text using dagger"
}

@Module
interface FragmentModule {
    @Binds
    @IntoMap
    @StringKey("br.com.experiment.daggerforandroid._7_fragment_factory_map.MainFragment")
    fun bindMainFragment(mainFragment: MainFragment): Fragment
}
