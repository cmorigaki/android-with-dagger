package br.com.experiment.daggerforandroid._12_activity_injection_new

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import br.com.experiment.daggerforandroid.R
import javax.inject.Inject

class MainActivity @Inject constructor(
    private val textFromDagger: String
) : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
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