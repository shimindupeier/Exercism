class IsbnVerifier {

    fun isValid(number: String): Boolean {
        val numberList = number.split("(?=\\w)(?<=\\w)|-".toRegex()).toMutableList()

        return if (inputValid(numberList)) {
            var count = numberList.size
            val tmp = numberList.map { it }.fold(0) { sum, i ->
                sum + (if (i=="X") 10 else i.toInt()) * (count--)
            }
            tmp.mod(11) == 0
        } else false
    }

    private fun inputValid(input: List<String>): Boolean {
        return !(input.size != 10
                || (input.last() != "X" && input.last().matches( "[a-zA-Z]".toRegex()))
                || input.dropLast(1).any { it.matches( "[a-zA-Z]".toRegex()) })
    }
}
