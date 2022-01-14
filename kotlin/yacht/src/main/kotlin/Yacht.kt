object Yacht {

    fun solve(category: YachtCategory, vararg dices: Int): Int {
        return when ( category ) {
            YachtCategory.YACHT -> {
                if (dices.distinct().size == 1) 50 else 0
            }
            YachtCategory.ONES -> {
                val score = dices.fold(0) {
                        acc, i -> if (i == 1) acc + i else acc
                }
                score
            }
            YachtCategory.TWOS -> {
                val score = dices.fold(0) {
                        acc, i -> if (i == 2) acc + i else acc
                }
                score
            }
            YachtCategory.THREES -> {
                val score = dices.fold(0) {
                        acc, i -> if (i == 3) acc + i else acc
                }
                score
            }
            YachtCategory.FOURS -> {
                val score = dices.fold(0) {
                        acc, i -> if (i == 4) acc + i else acc
                }
                score
            }
            YachtCategory.FIVES -> {
                val score = dices.fold(0) {
                        acc, i -> if (i == 5) acc + i else acc
                }
                score
            }
            YachtCategory.SIXES -> {
                val score = dices.fold(0) {
                        acc, i -> if (i == 6) acc + i else acc
                }
                score
            }
            YachtCategory.FULL_HOUSE -> {
                val groups: Map<Int, Int> = dices.toList().groupingBy { it }.eachCount()
                val score = if (groups.containsValue(3)) dices.fold(0) {
                    sum, element -> sum + element
                } else 0
                score
            }
            YachtCategory.FOUR_OF_A_KIND -> {
                val groups: Map<Int, Int> = dices.toList().groupingBy { it }.eachCount()
                val num = groups.filterValues { it >= 4 }.keys
                val score = if (num.isEmpty()) 0 else num.first().times(4)
                score
            }
            YachtCategory.LITTLE_STRAIGHT -> {
                val groups = dices.sorted()
                return if ( groups.first() != 1 || groups.last() != 5) 0
                else {
                    val checkingList = groups.windowed(2, 1)
                    val checkSet = checkingList.map { it.last().minus(it.first()) == 1 }.toSet()
                    if (checkSet.size == 1 && checkSet.contains(true)) 30 else 0
                }
            }
            YachtCategory.BIG_STRAIGHT -> {
                val groups = dices.sorted()
                return if (groups.first() != 2 || groups.last() != 6) 0
                else {
                    val listToCheckInc = groups.windowed(2, 1)
                    val setToCheckInc = listToCheckInc.map { it.last().minus(it.first()) == 1 }.toSet()
                    if (setToCheckInc.size == 1 && setToCheckInc.contains(true)) 30 else 0
                }
            }
            YachtCategory.CHOICE -> {
                dices.fold(0) {acc, ele -> acc + ele}
            }
        }
    }
}
