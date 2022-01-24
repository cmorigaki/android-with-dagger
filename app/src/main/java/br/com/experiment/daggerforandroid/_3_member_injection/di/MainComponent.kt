package br.com.experiment.daggerforandroid._3_member_injection.di

import br.com.experiment.daggerforandroid._3_member_injection.MainFragment
import dagger.Component
import dagger.Module
import dagger.Provides

@Component(
    modules = [MainModule::class]
)
interface MainComponent {
    fun inject(fragment: MainFragment)
}

@Module
object MainModule {
    @Provides
    fun provideText(): String = "Text using dagger"
}