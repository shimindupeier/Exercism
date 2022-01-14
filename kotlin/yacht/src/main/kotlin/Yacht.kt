import YachtCategory.*

object Yacht {

    fun solve(category: YachtCategory, vararg dices: Int): Int {
        return when ( category ) {
            YACHT -> {
                if (dices.distinct().size == 1) 50 else 0
            }
            ONES, TWOS, THREES, FOURS, FIVES, SIXES -> {
                dices.filter { it == category.ordinal }.sum()
            }
            FULL_HOUSE -> {
                val groups: Map<Int, Int> = dices.toList().groupingBy { it }.eachCount()
                val score = if (groups.containsValue(3)) dices.fold(0) {
                    sum, element -> sum + element
                } else 0
                score
            }
            FOUR_OF_A_KIND -> {
                val groups: Map<Int, Int> = dices.toList().groupingBy { it }.eachCount()
                val num = groups.filterValues { it >= 4 }.keys
                val score = if (num.isEmpty()) 0 else num.first().times(4)
                score
            }
            LITTLE_STRAIGHT -> {
                val groups = dices.sorted().toSet()
                if (groups == setOf(1,2,3,4,5)) 30 else 0
            }
            BIG_STRAIGHT -> {
                val groups = dices.sorted().toSet()
                if (groups == setOf(2,3,4,5,6)) 30 else 0
            }
            CHOICE -> {
                dices.sum()
            }
        }
    }

    private fun increment(dices: IntArray, num: Int): Int {
        val score = dices.fold(0) { acc, i ->
            if (i == num) acc + i else acc
        }
        return score
    }
}
