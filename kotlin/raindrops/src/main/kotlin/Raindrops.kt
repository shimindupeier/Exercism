object Raindrops {

    fun convert(n: Int): String {
        val factorMap = hashMapOf(
            3 to "Pling",
            5 to "Plang",
            7 to "Plong"
        )

        val rainDropsString: String = factorMap.toSortedMap().map { i -> if (n.rem(i.key) == 0) i.value else ""}.toList().joinToString("")
        return if (rainDropsString == "") n.toString() else rainDropsString
    }
}
