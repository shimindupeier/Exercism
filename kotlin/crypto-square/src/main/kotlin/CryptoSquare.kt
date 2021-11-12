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
            /*val row = when {
                c < r -> c
                else -> r
            }*/
            val grid = condensedStr.windowed(col, col, true).toList().map { it.padEnd(col) }
            /*val tmpList = mutableListOf<String>()
            var tmpString = ""
            for (i in 0 until col) {
                for (j in 0 until row) {
                    tmpString += grid[j][i]
                }
                tmpList.add(tmpString)
                tmpString = ""
            }*/
            return (0 until col).joinToString(" ") { i -> grid.map { it[i] }.joinToString("") }
            //return (0 until col).map { i -> grid.map { it[i] }.joinToString("") }.joinToString(" ")
            //return tmpList.joinToString(" ")

        }
    }

}
