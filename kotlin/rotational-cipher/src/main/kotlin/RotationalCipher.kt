enum class Alphabet(val letterKey: Int) {
    A(0), B(1), C(2), D(3),
    M(12)
}

class RotationalCipher(k: Int) {

    private val key = k

    fun encode(text: String): String {
        return if (key == 0 || key == 26) text
        else {
            val textCharArray = text.toCharArray()
            val tmp = textCharArray.joinToString("") { getCodedKey(it, key) }
            tmp
        }

    }

    private fun getCodedKey(charText: Char, key: Int): String {
        val encodedLetter: String
        val encodedKey: Int

        if (charText.isLetter()) {
            encodedKey = (key + Alphabet.valueOf(charText.uppercase()).letterKey).mod(26)
            encodedLetter = Alphabet.values()[encodedKey].toString()
        } else {
            encodedLetter = charText.toString()
        }
        return if (charText.isUpperCase()) encodedLetter
        else encodedLetter.lowercase()
    }
}
