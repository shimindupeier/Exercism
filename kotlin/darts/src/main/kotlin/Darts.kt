import kotlin.math.pow
import kotlin.math.sqrt

object Darts {

    fun score(x: Any, y: Any /* choose proper types! */): Int {
        val xCoord: Double = if (x is Int) x.toDouble() else x.toString().toDouble()
        val yCoord: Double = if (y is Int) y.toDouble() else y.toString().toDouble()
        val xOrigin = 0
        val yOrigin = 0
        val dotPos = (xOrigin.minus(xCoord).pow(2.0)
                        + (yOrigin.minus(yCoord)).pow(2.0))
        val radius = sqrt(dotPos)

        val s = when {
            radius <= 1 -> 10
            (1 < radius && radius <= 5) -> 5
            (5 < radius && radius <= 10) -> 1
            else -> 0
        }
        return s
    }
}
