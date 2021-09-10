object Pangram {

    fun isPangram(input: String): Boolean {
        val alphabet = "abcdefghijklmnopqrstuvwxyz"
        val sortedInput = input.toLowerCase().filter { it.isLetter() }.toSortedSet().joinToString("").trim()
        return alphabet == sortedInput
    }
}
