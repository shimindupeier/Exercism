import kotlin.math.pow

object Wordy {

    fun answer(input: String): Int {

        val operators = listOf("plus", "minus", "multiplied", "divided", "cubed", "power")
        val strList: List<String> = parseString(input)
        for (s in 0 until strList.size - 1) {
            if ((isNumber(strList[s]) && isNumber(strList[s + 1])) ||
                !isNumber(strList[s]) && !isNumber(strList[s + 1])
            )
                throw Exception()
        }
        val operands = strList.filter { isNumber(it) }.map { n -> n.toInt() }
        val operations = strList.filter { operators.contains(it) }.toList()
        var result = 0

        return when {
            operations.isEmpty() && operands.size == 1 -> operands[0]
            operations.isNotEmpty() -> {
                val tmpOperands = operands.toMutableList()
                for (i in operations.indices) {
                    val op = operations[i]
                    result = when (op) {
                        "plus" -> {
                            tmpOperands[i].plus(tmpOperands[i + 1])
                        }
                        "minus" -> {
                            tmpOperands[i].minus(tmpOperands[i + 1])
                        }
                        "multiplied" -> {
                            tmpOperands[i].times(tmpOperands[i + 1])
                        }
                        "divided" -> {
                            tmpOperands[i].div(tmpOperands[i + 1])
                        }
                        "cubed" -> {
                            throw Exception()
                        }
                        "power" -> {
                            tmpOperands[i].toDouble().pow(tmpOperands[i + 1].toDouble()).toInt()
                        }
                        else -> {
                            tmpOperands[i]
                        }
                    }
                    tmpOperands[i + 1] = result
                }
                result
            }
            else -> throw Exception()
        }
    }

    private fun isNumber(n: String): Boolean {
        return try {
            n.toInt()
            true
        } catch (e: NumberFormatException) {
            false
        }
    }

    private fun parseString(i: String) =
        i.split("[\\s]".toRegex())
            .map { it.replace("[?]".toRegex(), "") }
            .filter { it != "by" }
            .drop(2)
}
