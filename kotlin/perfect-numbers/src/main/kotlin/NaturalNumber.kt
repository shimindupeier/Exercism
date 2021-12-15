import java.lang.RuntimeException

enum class Classification {
    DEFICIENT, PERFECT, ABUNDANT
}

fun classify(naturalNumber: Int): Classification {
    val factors = findFactors(naturalNumber)
    val aliquotSum = factors.sum()
    return when  {
        aliquotSum == naturalNumber -> Classification.PERFECT
        aliquotSum > naturalNumber -> Classification.ABUNDANT
        aliquotSum < naturalNumber -> Classification.DEFICIENT
        else -> throw RuntimeException()
    }
}

fun findFactors(naturalNumber: Int) : List<Int> {
    return if (naturalNumber < 1) throw RuntimeException()
    else {
        val factors: List<Int> = (1..naturalNumber.div(2))
            .filter { naturalNumber.mod(it) == 0 }
        factors
    }
}
