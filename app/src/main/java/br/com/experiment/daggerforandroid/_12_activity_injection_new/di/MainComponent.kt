package br.com.experiment.daggerforandroid._12_activity_injection_new.di

import android.app.Activity
import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.experiment.daggerforandroid._12_activity_injection_new.*
import dagger.*
import dagger.multibindings.IntoMap
import javax.inject.Provider
import kotlin.reflect.KClass

@Component(
    modules = [MainModule::class, FragmentModule::class, ViewModelModule::class, ActivityModule::class]
)
interface MainComponent {
    val activityProviders: Map<Class<out Activity>, @JvmSuppressWildcards Provider<Activity>>
    val fragmentFactory: FragmentFactory

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
    fun bindGeneralFragmentFactory(generalFragmentFactory: GeneralFragmentFactory) : FragmentFactory

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

@Module
interface ActivityModule {
    @Binds
    @IntoMap
    @ActivityKey(MainActivity::class)
    fun bindMainActivity(mainActivity: MainActivity): Activity
}

@MapKey
annotation class ActivityKey(val value: KClass<out Activity>)
