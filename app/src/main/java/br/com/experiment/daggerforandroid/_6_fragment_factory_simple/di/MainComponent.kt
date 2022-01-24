package br.com.experiment.daggerforandroid._6_fragment_factory_simple.di

import br.com.experiment.daggerforandroid._6_fragment_factory_simple.MainFragmentFactory
import dagger.Component
import dagger.Module
import dagger.Provides

@Component(
    modules = [MainModule::class]
)
interface MainComponent {
    fun getFragmentFactory(): MainFragmentFactory
}

@Module
object MainModule {
    @Provides
    fun provideText(): String = "Text using dagger"
}