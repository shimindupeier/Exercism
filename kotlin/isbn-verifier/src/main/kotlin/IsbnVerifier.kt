class IsbnVerifier {

    fun isValid(number: String): Boolean {
        val numberList = number.split("(?=\\d)(?<=\\d)|-".toRegex())

        return false
    }
}
