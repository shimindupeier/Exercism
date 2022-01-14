object Yacht {

    fun solve(category: YachtCategory, vararg dices: Int): Int {
        return when ( category ) {
            YachtCategory.YACHT -> {
                if (dices.distinct().size == 1) 50 else 0
            }
            YachtCategory.ONES -> {
                increment(dices, 1)
            }
            YachtCategory.TWOS -> {
                increment(dices, 2)
            }
            YachtCategory.THREES -> {
                increment(dices, 3)
            }
            YachtCategory.FOURS -> {
                increment(dices, 4)
            }
            YachtCategory.FIVES -> {
                increment(dices, 5)
            }
            YachtCategory.SIXES -> {
                increment(dices, 6)
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
                checkStraight(groups, 1, 5)
            }
            YachtCategory.BIG_STRAIGHT -> {
                val groups = dices.sorted()
                checkStraight(groups, 2, 6)
            }
            YachtCategory.CHOICE -> {
                dices.fold(0) {acc, ele -> acc + ele}
            }
        }
    }

    private fun checkStraight(groups: List<Int>, firstNum: Int, lastNum: Int) =
        if (groups.first() != firstNum || groups.last() != lastNum) 0
        else {
            val checkingList = groups.windowed(2, 1)
            val checkSet = checkingList.map { it.last().minus(it.first()) == 1 }.toSet()
            if (checkSet.size == 1 && checkSet.contains(true)) 30 else 0
        }

    private fun increment(dices: IntArray, num: Int): Int {
        val score = dices.fold(0) { acc, i ->
            if (i == num) acc + i else acc
        }
        return score
    }
}
