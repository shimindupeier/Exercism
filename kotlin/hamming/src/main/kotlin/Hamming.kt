object Hamming {

    fun compute(leftStrand: String, rightStrand: String): Int {

        if (leftStrand.length != rightStrand.length)
            throw IllegalArgumentException("left and right strands must be of equal length")

        if (leftStrand.isBlank()
            || leftStrand == rightStrand
        ) return 0

        val listLS = leftStrand.toList()
        val listRS = rightStrand.toList()
        var distance = 0
        listLS.forEachIndexed { index, c -> if (listRS[index].toString() != c.toString()) distance += 1 }

        return distance
    }
}
