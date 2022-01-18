import kotlin.math.pow
import kotlin.math.sqrt

object Darts {

    fun score(x: Any, y: Any /* choose proper types! */): Int {
        val xCoord: Double = if (x is Int) x.toDouble() else x.toString().toDouble()
        val yCoord: Double = if (y is Int) y.toDouble() else y.toString().toDouble()
        val xOrigin = 0
        val yOrigin = 0
        val dotPos = sqrt((xOrigin.minus(xCoord).pow(2.0)
                        + (yOrigin.minus(yCoord)).pow(2.0)))

        return when {
            dotPos <= 1 -> 10
            (1 < dotPos && dotPos <= 5) -> 5
            (5 < dotPos && dotPos <= 10) -> 1
            else -> 0
        }
    }
}
