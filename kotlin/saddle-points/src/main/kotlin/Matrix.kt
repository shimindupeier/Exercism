data class MatrixCoordinate(val row: Int, val col: Int)

class Matrix(saddleList: List<List<Int>>) {
    val saddlePoints = saddlePoints(saddleList)
}

fun saddlePoints(sl: List<List<Int>>): Set<MatrixCoordinate> {
    return if (sl.contains(emptyList())) emptySet()
    else {
        val resultSet: MutableSet<MatrixCoordinate> = mutableSetOf()

        sl.forEach { list ->
            val maxInt = list.maxOf { it }
            val colList = mutableListOf<Int>()
            list.forEachIndexed { index, value ->
                if (value == maxInt) {
                    sl.forEach { item -> colList.add(item[index]) }
                    val minInt = colList.minOf { it }
                    colList.forEachIndexed { colInd, colValue ->
                        if (colValue == minInt && value == colValue) {
                            resultSet.add(MatrixCoordinate(colInd + 1, index + 1))
                        }
                    }
                }
            }
        }
        resultSet
    }
}