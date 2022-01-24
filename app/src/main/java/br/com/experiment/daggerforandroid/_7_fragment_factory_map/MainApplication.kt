package br.com.experiment.daggerforandroid._7_fragment_factory_map

import android.app.Application
import br.com.experiment.daggerforandroid._7_fragment_factory_map.di.DaggerMainComponent
import br.com.experiment.daggerforandroid._7_fragment_factory_map.di.MainComponent

class MainApplication : Application() {
    val component: MainComponent = DaggerMainComponent.create()
}