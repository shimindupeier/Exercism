class DiamondPrinter {

    fun printToList(letter: Char): List<String> {
        val letterList = ('A'..letter).toList()
        val diamondDimension = letterList.count() * 2 - 1
        val diamond = MutableList(diamondDimension) { " " }
        var spacerL = diamondDimension / 2
        var spacerR = diamondDimension / 2
        var reverse = diamondDimension - 1

        letterList.mapIndexed { i, c ->
            val rowOfLetters = MutableList(diamondDimension) { " " }
            rowOfLetters[spacerL] = c.toString()
            rowOfLetters[spacerR] = c.toString()
            spacerL--
            spacerR++
            diamond[i] = rowOfLetters.joinToString("")
            diamond[reverse] = rowOfLetters.joinToString("")
            reverse--
        }

        return diamond
    }
}
