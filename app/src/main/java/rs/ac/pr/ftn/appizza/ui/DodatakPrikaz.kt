package rs.ac.pr.ftn.appizza.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import rs.ac.pr.ftn.appizza.R
import rs.ac.pr.ftn.appizza.model.Dodatak
import rs.ac.pr.ftn.appizza.model.DodatakPolozaj

@Composable
fun DodatakPrikaz (
    dodatak: Dodatak,
    polozaj: DodatakPolozaj?,
    modifier: Modifier = Modifier, // Nova linija
    onClickDodatak: () -> Unit
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
                .background(Color.Yellow)
                .padding(vertical = 8.dp, horizontal = 16.dp)
                .clickable{ onClickDodatak()} // NOVA LINIJA

    ) {
        Checkbox(
            checked = (polozaj != null),
            onCheckedChange = { }
        )

        Column(
            modifier = Modifier.weight(1f, fill = true)
                .padding(start = 4.dp)
        ) {
            Text(text = stringResource(dodatak.dodatakIme),
                style = MaterialTheme.typography.bodyLarge)
            Text(text = stringResource(polozaj?.naziv ?: R.string.polozaj_bez),
                style = MaterialTheme.typography.bodySmall)
        }
    }
}

@Preview
@Composable
fun DodatakPrikazPreview() {
    DodatakPrikaz(
        dodatak = Dodatak.Paprika,
        polozaj = DodatakPolozaj.Cela,
        onClickDodatak = {}
    )
}












