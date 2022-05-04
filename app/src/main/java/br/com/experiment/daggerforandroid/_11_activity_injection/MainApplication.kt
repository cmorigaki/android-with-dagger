package br.com.experiment.daggerforandroid._11_activity_injection

import android.app.Application
import br.com.experiment.daggerforandroid._11_activity_injection.di.DaggerMainComponent
import br.com.experiment.daggerforandroid._11_activity_injection.di.MainComponent

class MainApplication : Application() {

    lateinit var component: MainComponent
    override fun onCreate() {
        super.onCreate()
        component = DaggerMainComponent.factory().create(this.applicationContext)
    }
}