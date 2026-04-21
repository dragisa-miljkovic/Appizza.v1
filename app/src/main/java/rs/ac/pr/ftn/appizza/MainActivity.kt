package rs.ac.pr.ftn.appizza

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import rs.ac.pr.ftn.appizza.model.Dodatak
import rs.ac.pr.ftn.appizza.model.DodatakPolozaj
import rs.ac.pr.ftn.appizza.ui.DodatakPrikaz
import rs.ac.pr.ftn.appizza.ui.PizzaScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Column {
                Text(text = "Hello Worlддддd!")
                PizzaScreen()
            }

        }
    }
}