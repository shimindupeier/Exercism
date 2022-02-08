data class MatrixCoordinate(val row: Int, val col: Int)

class Matrix(saddleList: List<List<Int>>) {
    val saddlePoints = saddlePoints(saddleList)
}

fun saddlePoints(sl: List<List<Int>>): Set<MatrixCoordinate> {
    return if (sl.contains(emptyList())) emptySet()
    else {
        var row : Int
        var col : Int
        val resultSet : MutableSet<MatrixCoordinate> = mutableSetOf()

        sl.forEach { item ->
            val maxEleIndex: Int = item.indexOf( item.maxOf { it } )
            val slCol = sl
            val colList = mutableListOf<Int>()
            slCol.forEach { item ->
                colList.add(item[maxEleIndex])
            }
            val minEleIndex = colList.indexOf(colList.minOf { it })
            row = item.maxOf { it }
            col = colList.minOf { it }
            if (col == row)
                resultSet.add(MatrixCoordinate(minEleIndex+1, maxEleIndex+1))
        }
        return resultSet
    }
}