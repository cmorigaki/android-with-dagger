package br.com.experiment.daggerforandroid._2_wrong_dagger

import android.app.Application
import br.com.experiment.daggerforandroid._2_wrong_dagger.di.DaggerMainComponent
import br.com.experiment.daggerforandroid._2_wrong_dagger.di.MainComponent

class MainApplication : Application() {
    val component: MainComponent = DaggerMainComponent.create()
}