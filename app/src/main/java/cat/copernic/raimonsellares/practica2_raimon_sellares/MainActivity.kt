package cat.copernic.raimonsellares.practica2_raimon_sellares

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.findNavController
import androidx.navigation.ui.*

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))


        //Back Button
        val navController = findNavController(R.id.nav_host_fragment)

        //Back Button
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.FirstFragment
            ))

        //Back Button
        setupActionBarWithNavController(navController, appBarConfiguration)
        NavigationUI.setupActionBarWithNavController(this,navController)
    }

    //Back Button
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration)
    }

    //Menú
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
    //Menú
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
                share()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    //Funció item menú
    fun snackbarMenu() {
        Snackbar.make(
            findViewById(android.R.id.content),
            "Raimon Sellarès Feiner",
            Snackbar.LENGTH_LONG
        )
            .setAction("Action", null).show()
    }
    //Funció item menú
    fun share() {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "Descarrega l'app TOP SONGS - La millor música")
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)

    }
}