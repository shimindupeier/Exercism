object Wordy {

    fun answer(input: String): Int {
        val strList: List<String> = parseString(input)
        val operands = strList.filter { isNumber(it) }.map { n -> n.toInt() }
        val operations = strList.filterNot { isNumber(it) }.toList()

        return when {
            operations.isEmpty() -> operands[0]
            operations.size == 1 -> {
                val x = operands[0]
                val y = operands[1]
                when (operations[0]) {
                    "plus" -> x.plus(y)
                    "minus" -> x.minus(y)
                    else -> -1
                }
            }
            operations.size == 2 && operands.size == 2 -> {
                val x = operands[0]
                val y = operands[1]
                if (operations.contains("multiplied")) x.times(y)
                else x.div(y)
            }
            operations.size > 1 -> {
                var result = 0
                val tmpOperands = operands.toMutableList()
                for (i in operations.indices) {
                    result = if (operations[i] == "plus") {
                        tmpOperands[i].plus(tmpOperands[i + 1])
                    } else {
                        tmpOperands[i].minus(tmpOperands[i + 1])
                    }
                    tmpOperands[i+1] = result
                }
                result
            }
            else -> -1
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

    private fun parseString(i: String): List<String> =
        i.split("[\\s]".toRegex())
            .map { it.replace("[?]".toRegex(), "") }
            .drop(2)
}
