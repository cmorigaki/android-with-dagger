package br.com.experiment.daggerforandroid._5_dagger_android_lifecycle

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import br.com.experiment.daggerforandroid._5_dagger_android_lifecycle.di.DaggerMainComponent
import br.com.experiment.daggerforandroid._5_dagger_android_lifecycle.di.MainComponent
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.HasAndroidInjector

import dagger.android.DispatchingAndroidInjector
import dagger.android.support.AndroidSupportInjection

import javax.inject.Inject

class MainApplication : Application(), HasAndroidInjector {
    @Inject
    protected lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>
    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector

    val component: MainComponent = DaggerMainComponent.create().also {
        it.inject(this)
    }

    override fun onCreate() {
        super.onCreate()
        this.registerActivityLifecycleCallbacks(
            object : ActivityLifecycleCallbacks {
                override fun onActivityCreated(activity: Activity, bundle: Bundle?) {
                    // AndroidInjection.inject(activity)
                    if (activity is FragmentActivity) {
                        activity.supportFragmentManager.registerFragmentLifecycleCallbacks(
                            object : FragmentManager.FragmentLifecycleCallbacks() {
                                override fun onFragmentPreCreated(
                                    fragmentManager: FragmentManager,
                                    fragment: Fragment,
                                    savedInstanceState: Bundle?
                                ) {
                                    super.onFragmentCreated(
                                        fragmentManager,
                                        fragment,
                                        savedInstanceState
                                    )
                                    AndroidSupportInjection.inject(fragment)
                                }
                            },
                            true
                        )
                    }
                }

                override fun onActivityStarted(activity: Activity) = Unit
                override fun onActivityResumed(activity: Activity) = Unit
                override fun onActivityPaused(activity: Activity) = Unit
                override fun onActivityStopped(activity: Activity) = Unit
                override fun onActivitySaveInstanceState(activity: Activity, p1: Bundle) = Unit
                override fun onActivityDestroyed(activity: Activity) = Unit
            }
        )
    }
}