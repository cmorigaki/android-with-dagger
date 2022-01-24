package br.com.experiment.daggerforandroid._8_fragment_factory_fragmentkey

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.experiment.daggerforandroid.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        supportFragmentManager.fragmentFactory = (application as MainApplication).component.getFragmentFactory()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(
                    R.id.container,
                    MainFragment::class.java,
                    null,
                )
                .commitNow()
        }
    }
}