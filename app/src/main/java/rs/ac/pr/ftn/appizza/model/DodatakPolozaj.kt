package rs.ac.pr.ftn.appizza.model

import androidx.annotation.StringRes
import rs.ac.pr.ftn.appizza.R

enum class DodatakPolozaj (
    @StringRes val naziv: Int
){
    Levo(R.string.polozaj_levo),
    Desno(R.string.polozaj_desno),
    Cela(R.string.polozaj_cela)
}