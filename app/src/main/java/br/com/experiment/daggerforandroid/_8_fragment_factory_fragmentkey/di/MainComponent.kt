package br.com.experiment.daggerforandroid._8_fragment_factory_fragmentkey.di

import androidx.fragment.app.Fragment
import br.com.experiment.daggerforandroid._8_fragment_factory_fragmentkey.MainFragment
import br.com.experiment.daggerforandroid._8_fragment_factory_fragmentkey.GeneralFragmentFactory
import dagger.*
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass

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
    @FragmentKey(MainFragment::class)
    fun bindMainFragment(mainFragment: MainFragment): Fragment
}

@MapKey
annotation class FragmentKey(val value: KClass<out Fragment>)