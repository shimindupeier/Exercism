object Yacht {

    fun solve(category: YachtCategory, vararg dices: Int): Int {
        return when ( category ) {
            YachtCategory.YACHT -> {
                if (dices.distinct().size == 1) 50 else 0
            }
            YachtCategory.ONES -> {
                val output = dices.fold(0) {
                        acc, i -> if (i == 1) acc + i else acc
                }
                output
            }

            else -> 0
        }
    }
}
