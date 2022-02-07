data class MatrixCoordinate(val row: Int, val col: Int)

class Matrix(saddleList: List<List<Int>>) {
    val saddlePoints = saddlePoints(saddleList)
}

fun saddlePoints(sl: List<List<Int>>): Set<MatrixCoordinate> {
    return if (sl.contains(emptyList())) emptySet()
    else {
        var row : Int
        var col : Int
        val returnSet : MutableSet<MatrixCoordinate> = mutableSetOf()
        sl.forEach { list ->
            val listMaxNumInd: Int = list.indexOf( list.maxOf { it } )
            val slCol = sl
            val temp = mutableListOf<Int>()
            slCol.forEach { row2 ->
                temp.add(row2[listMaxNumInd])
            }
            val colMinNumInd = temp.indexOf(temp.minOf { it })
            row = list.maxOf { it }
            col = temp.minOf { it }
            if (col == row)
                returnSet.add(MatrixCoordinate(colMinNumInd+1, listMaxNumInd+1))
        }
        return returnSet
    }
}