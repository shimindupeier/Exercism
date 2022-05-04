object PigLatin {

    fun translate(phrase: String): String {
        val vowel = listOf('a', 'e', 'i', 'o', 'u')
        val vowelSound = listOf("xr", "yt")
        val consonant = ('a'..'z').toList().filterNot { vowel.contains(it) }
        val splitPhrase = phrase.split(" ")

        return splitPhrase.joinToString(" ") { word ->
            val phraseEnding = "ay"
            when {
                word.first() in vowel || word.take(2) in vowelSound -> word + phraseEnding
                word.first() in consonant -> {
                    if (word.contains('y') && word.indexOf('y') != 0)
                        word.dropWhile { it in consonant && it != 'y' }
                            .plus(word.takeWhile { it in consonant && it != 'y' })
                            .plus(phraseEnding)
                    else if (word.contains("qu")) {
                        val indexOfU = word.indexOf("u")
                        word.substring(indexOfU + 1, word.length) + word.substring(0, indexOfU + 1) + phraseEnding
                    } else
                        word.dropWhile { it in consonant }
                            .plus(word.takeWhile { it in consonant })
                            .plus(phraseEnding)
                }
                else -> ""
            }
        }
    }
}
