package rs.ac.pr.ftn.appizza.model

import androidx.annotation.StringRes
import rs.ac.pr.ftn.appizza.R

enum class Dodatak(
    @StringRes val dodatakIme: Int
) {
    Pavlaka(R.string.dodatak_pavalaka),
    Majonez(R.string.dodatak_majonez),
    Masline(R.string.dodatak_masline),
    Kecap(R.string.dodatak_kecap),
    Sir(R.string.dodatak_sir),
    Paprika(R.string.dodatak_paprika)
}