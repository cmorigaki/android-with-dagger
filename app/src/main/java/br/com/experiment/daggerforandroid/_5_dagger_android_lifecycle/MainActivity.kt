package br.com.experiment.daggerforandroid._5_dagger_android_lifecycle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.experiment.daggerforandroid.R
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(
                    R.id.container,
                    MainFragment(),
                )
                .commitNow()
        }
    }
}