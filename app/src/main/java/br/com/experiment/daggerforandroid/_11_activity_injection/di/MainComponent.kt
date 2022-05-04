package br.com.experiment.daggerforandroid._11_activity_injection.di

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.experiment.daggerforandroid._11_activity_injection.*
import dagger.*
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass

@Component(
    modules = [MainModule::class, FragmentModule::class, ViewModelModule::class]
)
interface MainComponent {
    fun inject(activity: MainActivity)
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

@Module
interface ViewModelModule {
    @Binds
    fun bindsViewModelProvider(viewModelProviderFactory: ViewModelProviderFactory) : ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel
}

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)
