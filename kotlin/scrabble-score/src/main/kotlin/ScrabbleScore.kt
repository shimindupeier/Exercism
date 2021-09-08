object ScrabbleScore {

    private fun scoreLetter(c: Char): Int {
        val letterMap = mapOf(
            1 to setOf('A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T'),
            2 to setOf('D', 'G'),
            3 to setOf('B', 'C', 'M', 'P'),
            4 to setOf('F', 'H', 'V', 'W', 'Y'),
            5 to setOf('K'),
            8 to setOf('J', 'X'),
            10 to setOf('Q', 'Z')
        )
        return letterMap.filter { v -> v.value.contains(c) }.keys.first()
    }

    fun scoreWord(word: String): Int {
        val wordChar = word.toUpperCase().toList()

        return wordChar.sumBy { i -> scoreLetter(i) }
    }
}
