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
            else -> 0
        }
    }
}
