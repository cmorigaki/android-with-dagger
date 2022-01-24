package br.com.experiment.daggerforandroid._9_provide_context

import android.app.Application
import br.com.experiment.daggerforandroid._9_provide_context.di.DaggerMainComponent
import br.com.experiment.daggerforandroid._9_provide_context.di.MainComponent

class MainApplication : Application() {

    lateinit var component: MainComponent
    override fun onCreate() {
        super.onCreate()
        component = DaggerMainComponent.factory().create(this.applicationContext)
    }
}