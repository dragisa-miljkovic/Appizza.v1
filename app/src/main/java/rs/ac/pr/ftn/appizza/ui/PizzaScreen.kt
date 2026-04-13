package rs.ac.pr.ftn.appizza.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import rs.ac.pr.ftn.appizza.R
import rs.ac.pr.ftn.appizza.model.Dodatak
import rs.ac.pr.ftn.appizza.model.DodatakPolozaj
import java.util.Locale

@Preview
@Composable
fun PizzaScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        ListaDodataka(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f, fill = true)
        )

        PoruciDugme(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
    }
}

@Composable
fun ListaDodataka(
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(Dodatak.entries) { dodatak ->
            DodatakPrikaz(
                dodatak = dodatak,
                polozaj = DodatakPolozaj.Levo,
                onClickDodatak = {
                    // TODO
                } )
        }
    }
}

@Composable
fun PoruciDugme(
    modifier: Modifier = Modifier
) {
    Button(
        modifier = modifier,
        onClick = {}
    ) {
        Text(
            stringResource(R.string.dugme_poruci)
                .uppercase(Locale.getDefault())
        )
    }
}



