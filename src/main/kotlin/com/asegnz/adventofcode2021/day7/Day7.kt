import java.io.File
import kotlin.math.sign

internal class Day7 {

    companion object {
        fun usoCombustible(horizontal: Int, filename: String, old: Boolean, calculaMejor: Boolean): Long {
            val horizontales = mutableListOf<Int>()
            File(filename).forEachLine { linea ->
                val pieces = linea.split(",")
                pieces.map { horizontales.add(it.toInt()) }
            }
            val mediana = mediana(horizontales)
            println("Media de horizontales: ${horizontales.sum() / horizontales.size}")
            println("Mediana de horizontales: $mediana")
            if (old) {
                return calculaCombustible(horizontal, horizontales)

            } else {
                if (!calculaMejor) {
                    return calculaCombustible2(horizontal, horizontales)
                }
                else {
                    println("Tomamos $horizontal como primer valor, iremos oscilando arriba y abajo hasta conocer el menor combustible")
                    var valor = horizontal
                    var mejorCombustible = Long.MAX_VALUE
                    var contador = 0
                    var signo = 1
                    while (valor >= 0 && valor <= 3000) {
                        val combustible = calculaCombustible2(valor, horizontales)
                        if (combustible < mejorCombustible) {
                            println("Mejoramos combustible con $valor horizontal y combustible $combustible")
                            mejorCombustible = combustible
                        }
                        contador++
                        valor += contador * signo
                        signo *= -1
                        println("Valor: $valor, Contador: $contador, Signo: $signo")
                    }
                    return mejorCombustible
                }
            }
        }

        private fun calculaCombustible2(horizontal: Int, horizontales: MutableList<Int>): Long {
            var combustible = 0L
            horizontales.forEach {
                val movimientos = Math.abs(it - horizontal)
                combustible += costeMovimiento(movimientos)
            }
            return combustible
        }

        private fun costeMovimiento(movimientos: Int): Long {
            var coste = 0L
            if (movimientos > 0) {
                for (i in 1..movimientos) {
                    coste += i
                }
            }
            return coste
        }

        private fun mediana(horizontales: MutableList<Int>): Int {
            val aux = horizontales.sorted()
            return aux.get(horizontales.size / 2)
        }

        private fun calculaCombustible(horizontal: Int, horizontales: List<Int>): Long {
            var combustible = 0L
            horizontales.forEach {
                combustible += Math.abs(it - horizontal)
            }
            return combustible
        }

    }
}