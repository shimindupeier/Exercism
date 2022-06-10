class IsbnVerifier {

    fun isValid(number: String): Boolean {
        val numberList = number.split("(?=\\w)(?<=\\w)|-".toRegex()).toMutableList()

        return if (numberList.size != 10
            || (numberList.last() != "X" && numberList.last().matches( "[a-zA-Z]".toRegex()))
            || numberList.dropLast(1).any { it.matches( "[a-zA-Z]".toRegex()) }
        ) false
        else {
            if (numberList.last() == "X") numberList[numberList.lastIndex] = "10"
            var count = numberList.size

            val tmp = numberList.map { it.toInt() }.fold(0) { sum, i ->
                sum + i * (count--)
            }
            tmp.mod(11) == 0
        }
    }
}
