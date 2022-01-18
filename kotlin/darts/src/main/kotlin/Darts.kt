import kotlin.math.hypot
import kotlin.math.pow
import kotlin.math.sqrt

object Darts {

    fun score(x: Number, y: Number): Int {
        val xOrigin = 0
        val yOrigin = 0
        val dotPos = sqrt((xOrigin.minus(x.toDouble()).pow(2.0)
                        + (yOrigin.minus(y.toDouble())).pow(2.0)))

        return when {
            dotPos <= 1 -> 10
            dotPos <= 5 -> 5
            dotPos <= 10 -> 1
            else -> 0
        }
    }
}
