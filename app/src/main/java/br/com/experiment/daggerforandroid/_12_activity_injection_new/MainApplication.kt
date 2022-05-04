package br.com.experiment.daggerforandroid._12_activity_injection_new

import android.app.Application
import br.com.experiment.daggerforandroid._12_activity_injection_new.di.DaggerMainComponent
import br.com.experiment.daggerforandroid._12_activity_injection_new.di.MainComponent

class MainApplication : Application() {

    lateinit var component: MainComponent
    override fun onCreate() {
        super.onCreate()
        component = DaggerMainComponent.factory().create(this.applicationContext)
    }
}