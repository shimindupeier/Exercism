import kotlin.math.pow

object ArmstrongNumber {

    fun check(input: Int): Boolean {
        val intInList = input.toString().toList()
        val intLength = intInList.size.toDouble()
        return intInList.sumBy { it.toString().toDouble().pow(intLength).toInt() } == input
    }

}