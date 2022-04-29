object PigLatin {

    fun translate(phrase: String): String {
        val vowelList = listOf('a', 'e', 'i', 'o', 'u')
        val vowelSoundList = listOf("xr", "yt")
        val consonantList = ('a'..'z').toList()
            .filterNot { vowelList.contains(it) }

        return when {
            phrase.first() in vowelList -> phrase + "ay"
            phrase.take(2) in vowelSoundList -> phrase + "ay"
            phrase.first() in consonantList -> {
                if (phrase.startsWith("qu"))
                    phrase.drop(2) + phrase.take(2) + "ay"
                else if (phrase.startsWith("y"))
                    phrase.drop(1) + phrase.take(1) + "ay"
                else if (phrase.slice(1 .. 1) == "y")
                    phrase.drop(1) + phrase.take(1) + "ay"
                else if (phrase.contains('y'))
                    phrase.dropWhile { it in consonantList && it != 'y'}
                        .plus(phrase.takeWhile { it in consonantList && it != 'y' })
                        .plus("ay")
                else if (phrase.contains("qu")) {
                    val indexofU = phrase.indexOf("u")
                    phrase.substring(indexofU+1, phrase.length) + phrase.substring(0, indexofU+1) + "ay"
                } else
                    phrase.dropWhile { it in consonantList }
                        .plus(phrase.takeWhile { it in consonantList })
                        .plus("ay")
            }
            else -> ""
        }
    }
}
