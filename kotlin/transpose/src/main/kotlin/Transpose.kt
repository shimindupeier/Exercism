object Transpose {

    fun transpose(input: List<String>): List<String> {
        return if (input.isEmpty()) emptyList()
        else {
            val column = input.size
            val row = input.maxBy { it.length }!!.length
            val paddedInput = input.map { it.padEnd(row) }
            val outputRow = "".padEnd(column)
            val transponseList: MutableList<String> = mutableListOf()
            var tmp: String = ""
            for (i in 0 until row) {
                for (j in 0 until column) {
                    tmp += paddedInput[j][i]
                }
                transponseList.add(tmp)
                tmp = ""
            }
            transponseList
        }
        /*else if (input.size == 1) {
            val row1 = input.first().map { it.toString() }.toList()
            row1
        } else {
            val r1 = input.first().toList()
            val r2 = input.last().toList()
            val transposeList = r1.mapIndexed { index, c ->
                                                (c + r2[index].toString()) }.toList()
            transposeList
        }*/
    }
}
