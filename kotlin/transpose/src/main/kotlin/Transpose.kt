object Transpose {

    fun transpose(input: List<String>): List<String> {
        return if (input.isEmpty()) emptyList()
        else {
            val inputNumItem = input.size
            val inputMaxNumSize = input.maxBy { it.length }!!.length
//            val paddedInput = emptyList<>()
//            val outputRow = "".padEnd(outputCol)
            val transposeList: MutableList<String> = mutableListOf()
            var tmp = ""
            for (i in 0 until inputMaxNumSize) {
                for (j in 0 until inputNumItem) {
                    try {
                        tmp += input[j][i]
                    } catch (e: IndexOutOfBoundsException) {
                        try {
//                            if (input[j+1][i].isLetter() || input[j+1][i].equals(" "))
                            if (input[j+1][i].toString().isBlank() || input[j+1][i].toString().isNotEmpty())
                                tmp += " "
                        } catch (a: ArrayIndexOutOfBoundsException) {
                            break
                        } catch (s: StringIndexOutOfBoundsException) {
                            break
                        }
                    }
                }
                transposeList.add(tmp)
                tmp = ""
            }
            transposeList
        }
    }
}
