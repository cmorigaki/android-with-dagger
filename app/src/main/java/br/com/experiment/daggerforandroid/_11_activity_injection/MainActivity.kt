package br.com.experiment.daggerforandroid._11_activity_injection

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import br.com.experiment.daggerforandroid.R
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var textFromDagger: String

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MainApplication).component.run {
            inject(this@MainActivity)
            supportFragmentManager.fragmentFactory = getFragmentFactory()
        }
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

    override fun onResume() {
        super.onResume()
        Log.d("Dagger", textFromDagger)
    }
}