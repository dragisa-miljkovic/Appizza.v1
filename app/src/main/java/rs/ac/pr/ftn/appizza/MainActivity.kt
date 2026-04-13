package rs.ac.pr.ftn.appizza

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import rs.ac.pr.ftn.appizza.model.Dodatak
import rs.ac.pr.ftn.appizza.model.DodatakPolozaj
import rs.ac.pr.ftn.appizza.ui.DodatakPrikaz
import rs.ac.pr.ftn.appizza.ui.PizzaScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PizzaScreen()

        }
    }
}