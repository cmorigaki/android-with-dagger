package br.com.experiment.daggerforandroid._3_member_injection

import android.app.Application
import br.com.experiment.daggerforandroid._3_member_injection.di.DaggerMainComponent
import br.com.experiment.daggerforandroid._3_member_injection.di.MainComponent

class MainApplication : Application() {
    val component: MainComponent = DaggerMainComponent.create()
}