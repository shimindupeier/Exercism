object Transpose {

    fun transpose(input: List<String>): List<String> {
        return if (input.isEmpty()) emptyList()
        else {
            val inputMaxNumSize = input.maxBy { it.length }?.length ?: 1

            (0 until inputMaxNumSize)
                    .map { i -> input.map { it.getOrNull(i) }.dropLastWhile { it == null }.map { it ?: ' '}.joinToString("")}
       }
    }
}
