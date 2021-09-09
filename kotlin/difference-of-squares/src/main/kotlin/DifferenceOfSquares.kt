class Squares(val firstN : Int) {

    fun sumOfSquares(): Int {
        return (1..firstN).sumBy { it*it }
    }

    fun squareOfSum(): Int {
        return Math.pow((1..firstN).sumBy { it }.toDouble(), 2.0).toInt()
    }

    fun difference(): Int {
        return squareOfSum().minus(sumOfSquares())
    }
}
