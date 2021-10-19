import kotlin.math.roundToInt
import kotlin.math.sqrt

object CryptoSquare {

    fun ciphertext(plaintext: String): String {
        return if (plaintext.isEmpty()) "" else {
            val condensedStr = plaintext.toLowerCase().trim().replace(Regex("\\p{Punct}|\\s"), "")
            val strLength = condensedStr.count()
            val c = sqrt(strLength.toDouble()).roundToInt()
            val r = strLength.div(c)
            val grid = condensedStr.windowed(c,c).toList()
            val tmpList = mutableListOf<String>()
            var tmpString = ""
            for (i in 0 until r) {
                for (j in 0 until c) {
                    tmpString += grid[j][i].toString()
                }
                tmpList.add(tmpString)
                tmpString = ""
            }
            return tmpList.joinToString(" ")
        }
    }

}
