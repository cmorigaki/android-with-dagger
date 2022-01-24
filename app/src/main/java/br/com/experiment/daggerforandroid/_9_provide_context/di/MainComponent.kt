package br.com.experiment.daggerforandroid._9_provide_context.di

import android.content.Context
import androidx.fragment.app.Fragment
import br.com.experiment.daggerforandroid._9_provide_context.MainFragment
import br.com.experiment.daggerforandroid._9_provide_context.GeneralFragmentFactory
import dagger.*
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass

@Component(
    modules = [MainModule::class, FragmentModule::class]
)
interface MainComponent {
    fun getFragmentFactory(): GeneralFragmentFactory

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): MainComponent
    }
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