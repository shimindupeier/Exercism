enum class Alphabet(val letterKey: Int) {
    A(0), B(1), C(2), D(3),
    M(12)
}
class RotationalCipher(k: Int) {

    private val key = k

    fun encode(text: String): String {
        return if (key == 0 || key == 26) text
        else {
            when (text.uppercase()) {
                Alphabet.A.name -> getCodedKey(Alphabet.A.letterKey, text)
                else -> ""
            }

        }
    }

    private fun getCodedKey(cipher: Int, text: String): String {
        val encodedKey = (key + cipher).mod(26)
        val encodedLetter = Alphabet.values()[encodedKey].toString()
        return if (text.first().isUpperCase()) encodedLetter
                else encodedLetter.lowercase()
    }
}
