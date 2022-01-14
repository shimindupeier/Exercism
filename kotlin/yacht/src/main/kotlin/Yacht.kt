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
                if (dices.groupBy { it }.values.map { it.size }.toSet() == setOf(2, 3)) dices.sum() else 0
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
}
