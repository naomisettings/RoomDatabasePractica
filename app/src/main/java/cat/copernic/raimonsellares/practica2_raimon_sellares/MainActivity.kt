package cat.copernic.raimonsellares.practica2_raimon_sellares

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.about -> {
                snackbarMenu()
                true
            }
            R.id.share -> {
                shareMenu()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun snackbarMenu() {
        Snackbar.make(
            findViewById(android.R.id.content),
            "Raimon Sellarès Feiner",
            Snackbar.LENGTH_LONG
        )
            .setAction("Action", null).show()
    }

    fun shareMenu() {
        Snackbar.make(
            findViewById(android.R.id.content),
            "R",
            Snackbar.LENGTH_LONG
        )
            .setAction("Action", null).show()
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration)
    }
}