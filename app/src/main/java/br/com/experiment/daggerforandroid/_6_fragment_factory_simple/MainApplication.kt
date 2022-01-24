package br.com.experiment.daggerforandroid._6_fragment_factory_simple

import android.app.Application
import br.com.experiment.daggerforandroid._6_fragment_factory_simple.di.DaggerMainComponent
import br.com.experiment.daggerforandroid._6_fragment_factory_simple.di.MainComponent

class MainApplication : Application() {
    val component: MainComponent = DaggerMainComponent.create()
}