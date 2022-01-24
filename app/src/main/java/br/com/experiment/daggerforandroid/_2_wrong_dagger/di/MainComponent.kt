package br.com.experiment.daggerforandroid._2_wrong_dagger.di

import br.com.experiment.daggerforandroid._2_wrong_dagger.MainFragment
import dagger.Component
import dagger.Module
import dagger.Provides

@Component(
    modules = [MainModule::class]
)
interface MainComponent {
    fun getFragment(): MainFragment
}

@Module
object MainModule {
    @Provides
    fun provideText(): String = "Text using dagger"
}