data class MatrixCoordinate(val row: Int, val col: Int)

class Matrix(saddleList: List<List<Int>>) {

    val saddlePoints = saddleList.flatMapIndexed { rowIndex, row ->
        val rowMax = row.maxOfOrNull { it }
        row.mapIndexedNotNull { colIndex, value ->
            val colMin = saddleList.minOf { it[colIndex] }
            if (value == rowMax && value == colMin)
                MatrixCoordinate(rowIndex + 1, colIndex + 1)
            else
                null
        }
    }.toSet()
    
}

fun saddlePoints(saddleList: List<List<Int>>): Set<MatrixCoordinate> {
    return if (saddleList.contains(emptyList())) emptySet()
    else {
        val resultSet: MutableSet<MatrixCoordinate> = mutableSetOf()

        saddleList.forEach { row ->
            val rowMax = row.maxOf { it }
            row.forEachIndexed addToCol@{ index, value ->
                if (value == rowMax) {
                    val colList = mutableListOf<Int>()
                    saddleList.forEach { item -> colList.add(item[index]) }
                    val colMin = colList.minOf { it }
                    colList.forEachIndexed { colInd, colValue ->
                        if (colValue == colMin && colValue == rowMax) {
                            resultSet.add(MatrixCoordinate(colInd + 1, index + 1))
                            if (row.toSet().size == 1 && row.size > 1)
                                return@addToCol
                        }
                    }
                }
            }
        }
        resultSet
    }
}