package rs.ac.pr.ftn.appizza.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import rs.ac.pr.ftn.appizza.R
import rs.ac.pr.ftn.appizza.model.Dodatak
import rs.ac.pr.ftn.appizza.model.DodatakPolozaj
import rs.ac.pr.ftn.appizza.model.Pizza
import java.text.NumberFormat
import java.util.Locale

//private var pizza = Pizza(
//    dodaci = mapOf(Dodatak.Masline to DodatakPolozaj.Cela,
//        Dodatak.Paprika to DodatakPolozaj.Cela)
//)
//    set(vrednost) {
//        Log.d("PizzaScreen", "Promenjiva pizza = $vrednost")
//        field = vrednost
//    }

// private var pizza by mutableStateOf(Pizza())

@Preview
@Composable
fun PizzaScreen(
    modifier: Modifier = Modifier
) {
    var pizza by rememberSaveable(stateSaver = Pizza.Saver) {
        mutableStateOf(Pizza())
    }
    Column(
        modifier = modifier
    ) {
        ListaDodataka(
            pizza = pizza,  // Novo
            onEditPizza = { pizza = it},  // Novo
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f, fill = true)
        )

        PoruciDugme(
            pizza = pizza,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
    }
}

@Composable
fun ListaDodataka(
    pizza: Pizza,
    onEditPizza: (Pizza) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(Dodatak.entries) { dodatak ->
            DodatakPrikaz(
                dodatak = dodatak,
                // polozaj = DodatakPolozaj.Levo,
                polozaj = pizza.dodaci[dodatak],
                onClickDodatak = {
                    val daLiJeDodat = pizza.dodaci[dodatak] != null
                    onEditPizza(pizza.saDodatkom(
                        dodatak = dodatak,
                        polozaj = if (daLiJeDodat) {
                            null
                        } else {
                            DodatakPolozaj.Cela
                        }
                    ))
                }
            )
        }
    }
}

@Composable
fun PoruciDugme(
    pizza: Pizza,
    modifier: Modifier = Modifier
) {
    Button(
        modifier = modifier,
        onClick = {}
    ) {
        val formaterValute = remember { NumberFormat.getCurrencyInstance() }
        val cena = formaterValute.format(pizza.cena)
        Text(
            stringResource(R.string.dugme_poruci, cena)
                .uppercase(Locale.getDefault())
        )
    }
}



