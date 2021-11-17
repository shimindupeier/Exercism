import kotlin.math.roundToInt
import kotlin.math.sqrt

object CryptoSquare {

    fun ciphertext(plaintext: String): String {
        return if (plaintext.isEmpty()) "" else {
            val condensedStr = plaintext.toLowerCase().trim().replace(Regex("\\p{Punct}|\\s"), "")
            val strLength = condensedStr.count()
            val c = sqrt(strLength.toDouble()).roundToInt()
            val r = strLength.toDouble().div(c).roundToInt()
            val col = when {
                c < r -> r
                else -> c
            }
            val grid = condensedStr.windowed(col, col, true).toList().map { it.padEnd(col) }
            return (0 until col).joinToString(" ") { i -> grid.map { it[i] }.joinToString("") }
        }
    }

}
