object PigLatin {

    fun translate(phrase: String): String {
        val vowelList = listOf('a', 'e', 'i', 'o', 'u')
        val vowelSoundList = listOf("xr", "yt")
        val consonantList = ('a'..'z').toList().filterNot { vowelList.contains(it) }
        val phraseInList = phrase.split(" ")

        return phraseInList.joinToString(" ") { word ->
            when {
                word.first() in vowelList || word.take(2) in vowelSoundList -> word + "ay"
                word.first() in consonantList -> {
                    if (word.startsWith("qu"))
                        word.drop(2) + word.take(2) + "ay"
                    else if (word.startsWith("y"))
                        word.drop(1) + word.take(1) + "ay"
                    else if (word.slice(1..1) == "y")
                        word.drop(1) + word.take(1) + "ay"
                    else if (word.contains('y'))
                        word.dropWhile { it in consonantList && it != 'y' }
                            .plus(word.takeWhile { it in consonantList && it != 'y' })
                            .plus("ay")
                    else if (word.contains("qu")) {
                        val indexOfU = word.indexOf("u")
                        word.substring(indexOfU + 1, word.length) + word.substring(0, indexOfU + 1) + "ay"
                    } else
                        word.dropWhile { it in consonantList }
                            .plus(word.takeWhile { it in consonantList })
                            .plus("ay")
                }
                else -> ""
            }
        }
    }
}
