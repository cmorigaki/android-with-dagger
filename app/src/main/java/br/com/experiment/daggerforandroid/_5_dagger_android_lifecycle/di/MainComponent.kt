package br.com.experiment.daggerforandroid._5_dagger_android_lifecycle.di

import br.com.experiment.daggerforandroid._5_dagger_android_lifecycle.MainApplication
import br.com.experiment.daggerforandroid._5_dagger_android_lifecycle.MainFragment
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjectionModule
import dagger.android.ContributesAndroidInjector

@Component(
    modules = [MainModule::class, AndroidInjectionModule::class, FragmentModule::class]
)
interface MainComponent {
    fun inject(mainApplication: MainApplication)
}

@Module
object MainModule {
    @Provides
    fun provideText(): String = "Text using dagger"
}

@Module
interface FragmentModule {
    @ContributesAndroidInjector
    fun mainFragment(): MainFragment
}