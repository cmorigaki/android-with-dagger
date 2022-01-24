package br.com.experiment.daggerforandroid._8_fragment_factory_fragmentkey

import android.app.Application
import br.com.experiment.daggerforandroid._8_fragment_factory_fragmentkey.di.DaggerMainComponent
import br.com.experiment.daggerforandroid._8_fragment_factory_fragmentkey.di.MainComponent

class MainApplication : Application() {
    val component: MainComponent = DaggerMainComponent.create()
}