package br.com.experiment.daggerforandroid._4_dagger_android

import android.app.Application
import br.com.experiment.daggerforandroid._4_dagger_android.di.DaggerMainComponent
import br.com.experiment.daggerforandroid._4_dagger_android.di.MainComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MainApplication : Application(), HasAndroidInjector {
    @Inject
    protected lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>
    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector

    val component: MainComponent = DaggerMainComponent.create().also {
        it.inject(this)
    }
}