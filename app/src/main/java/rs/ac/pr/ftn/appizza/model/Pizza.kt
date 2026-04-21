package rs.ac.pr.ftn.appizza.model

import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.listSaver

data class Pizza(
    val dodaci: Map<Dodatak, DodatakPolozaj> = emptyMap()
) {
    val cena: Double
        get() = 300 + dodaci.asSequence()
            .sumOf { (_, dodatakPolozaj) ->
                when (dodatakPolozaj) {
                    DodatakPolozaj.Levo, DodatakPolozaj.Desno -> 20.0
                    DodatakPolozaj.Cela -> 40.0
                }
            }

    fun saDodatkom(dodatak: Dodatak, polozaj: DodatakPolozaj?): Pizza {
        return copy(
            dodaci = if (polozaj == null) {
                // Uklanjanje dodatka iz mape ako je položaj null
                dodaci - dodatak
            } else {
                // Dodavanje ili ažuriranje dodatka sa novim položajem
                dodaci + (dodatak to polozaj)
            }
        )
    }


    companion object {
        val Saver: Saver<Pizza, Any> = listSaver(
            save = { pizza ->
                pizza.dodaci.flatMap { (dodatak, polozaj) ->
                    listOf(dodatak.name, polozaj.name)
                }
            },
            restore = { restored ->
                val pairs = restored.chunked(2).associate { chunk ->
                    val dodatak = enumValueOf<Dodatak>(chunk[0] as String)
                    val polozaj = enumValueOf<DodatakPolozaj>(chunk[1] as String)
                    dodatak to polozaj
                }
                Pizza(dodaci = pairs)
            }
        )
    }
}
