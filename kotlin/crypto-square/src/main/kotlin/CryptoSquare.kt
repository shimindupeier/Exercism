import kotlin.math.roundToInt
import kotlin.math.sqrt

object CryptoSquare {

    fun ciphertext(plaintext: String): String {
        return if (plaintext.isEmpty()) "" else {
            val condensedStr = plaintext.toLowerCase().trim().replace(Regex("\\p{Punct}|\\s"), "")
            val strLength = condensedStr.count()
            var c = sqrt(strLength.toDouble()).roundToInt()
            var r = strLength.toDouble().div(c).roundToInt()
            if (c < r) {
                val tmp = c
                c = r
                r = tmp
            }
            val grid = condensedStr.windowed(c,c, true).toList().map { it.padEnd(c) }
            val tmpList = mutableListOf<String>()
            var tmpString = ""
            for (i in 0 until c) {
                for (j in 0 until r) {
                    tmpString += grid[j][i]
                }
                tmpList.add(tmpString)
                tmpString = ""
            }
            return tmpList.joinToString(" ")
        }
    }

}
