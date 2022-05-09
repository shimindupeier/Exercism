class DiamondPrinter {

    fun printToList(letter: Char): List<String> {
        val diamondInList = mutableListOf<String>()
        val letterList = ('A'..'Z').toList()

        if (letter == 'A')
            diamondInList.add("A")
        else {
            val numRowsCols = ('A'..letter).count()*2-1 //letterList.indexOf(letter) + 2
            var spacerL = numRowsCols/2
            var spacerR = numRowsCols/2

            for (i in 0 .. numRowsCols/2) {
                val rowToLetter = MutableList(numRowsCols) { " " }
                rowToLetter[spacerL] = letterList[i].toString()
                rowToLetter[spacerR] = letterList[i].toString()
                spacerL--
                spacerR++
                diamondInList.add(rowToLetter.joinToString(""))
            }

            for (i in numRowsCols/2-1 downTo 0) {
                diamondInList.add(diamondInList[i])
            }

            println(diamondInList)
        }

        return diamondInList
    }

}
