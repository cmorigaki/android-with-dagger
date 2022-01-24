package br.com.experiment.daggerforandroid._10_viewmodel_factory

import android.app.Application
import br.com.experiment.daggerforandroid._10_viewmodel_factory.di.DaggerMainComponent
import br.com.experiment.daggerforandroid._10_viewmodel_factory.di.MainComponent

class MainApplication : Application() {

    lateinit var component: MainComponent
    override fun onCreate() {
        super.onCreate()
        component = DaggerMainComponent.factory().create(this.applicationContext)
    }
}