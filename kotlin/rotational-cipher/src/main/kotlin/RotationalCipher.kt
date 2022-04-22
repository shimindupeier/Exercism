enum class Alphabet(val letterKey: Int) {
    A(0), B(1), C(2), D(3), E(4),
    F(5), G(6), H(7), I(8), J(9),
    K(10), L(11), M(12), N(13), O(14), P(15),
    Q(16), R(17), S(18), T(19), U(20),
    V(21), W(22), X(23), Y(24), Z(25)
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
