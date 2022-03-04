import kotlin.system.exitProcess

data class MatrixCoordinate(val row: Int, val col: Int)

class Matrix(saddleList: List<List<Int>>) {
    val saddlePoints = saddlePoints(saddleList)
}

fun saddlePoints(sl: List<List<Int>>): Set<MatrixCoordinate> {
    return if (sl.contains(emptyList())) emptySet()
    else {
        val resultSet: MutableSet<MatrixCoordinate> = mutableSetOf()

        sl.forEach  { list ->
            val maxInt = list.maxOf { it }
            list.forEachIndexed outer@ { index, value ->
                if (value == maxInt) {
                    val colList = mutableListOf<Int>()
                    sl.forEach { item -> colList.add(item[index]) }
                    val minInt = colList.minOf { it }
                    colList.forEachIndexed { colInd, colValue ->
                        if (colValue == minInt && colValue == value) {
                            resultSet.add(MatrixCoordinate(colInd + 1, index + 1))
                            if (list.toSet().size == 1 && list.size > 1)
                                return@outer
                        }
                    }
                }
            }
        }
        resultSet
    }
}