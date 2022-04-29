object PigLatin {

    fun translate(phrase: String): String {
        val phraseList = phrase.toList()
        val vowelList = listOf('a', 'e', 'i', 'o', 'u')
        val consonantList = ('a' .. 'z').toList()
            .filterNot { vowelList.contains(it) }

        return when (phraseList.first()) {
            in vowelList -> phrase + "ay"
            in consonantList -> {
                phrase.dropWhile { it in consonantList }
                    .plus(phrase.takeWhile { it in consonantList })
                    .plus("ay")
            }
            else -> ""
        }
    }
}
