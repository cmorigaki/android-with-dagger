package br.com.experiment.daggerforandroid._2_wrong_dagger

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.experiment.daggerforandroid.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(
                    R.id.container,
                    (applicationContext as MainApplication).component.getFragment()
                )
                .commitNow()
        }
    }
}