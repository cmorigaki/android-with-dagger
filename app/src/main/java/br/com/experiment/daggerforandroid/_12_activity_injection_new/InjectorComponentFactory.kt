package br.com.experiment.daggerforandroid._12_activity_injection_new

import android.app.Activity
import android.app.AppComponentFactory
import android.app.Application
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentFactory
import javax.inject.Provider

@RequiresApi(Build.VERSION_CODES.P)
class InjectorComponentFactory : AppComponentFactory() {

    private lateinit var application: MainApplication
    private val fragmentFactory: FragmentFactory by lazy { application.component.fragmentFactory }

    private val activityProviders: Map<String, Provider<Activity>> by lazy {
        application.component.activityProviders
            .mapKeys { (key, _) -> key.name }
    }

    override fun instantiateApplication(
        cl: ClassLoader, className: String
    ): Application {
        val instantiateApplication = super.instantiateApplication(cl, className)
        this.application = instantiateApplication as MainApplication
        return instantiateApplication
    }

    override fun instantiateActivity(
        cl: ClassLoader, className: String, intent: Intent?
    ): Activity {
        return (activityProviders[className]?.get()
            ?: super.instantiateActivity(cl, className, intent)).also {
            (it as? AppCompatActivity)?.supportFragmentManager?.fragmentFactory = fragmentFactory
        }
    }
}