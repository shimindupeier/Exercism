object Hamming {

    fun compute(leftStrand: String, rightStrand: String): Int {

        if (leftStrand.length != rightStrand.length)
            throw IllegalArgumentException("left and right strands must be of equal length")

        return if (leftStrand.isBlank() || leftStrand == rightStrand) {
            0
        } else {
            val listLS = leftStrand.toList()
            val listRS = rightStrand.toList()
            listLS.zip(listRS).filter { it.first != it.second }.sumBy { +1 }
        }
    }
}



