class RotationalCipher(k: Int) {

    // TODO: Implement proper constructor
    private val key = k

    fun encode(text: String): String {
        return if (key == 0 || key == 26) text
        else {

            ""
        }
    }
}
