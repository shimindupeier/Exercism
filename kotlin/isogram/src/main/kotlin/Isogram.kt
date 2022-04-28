object Isogram {

    fun isIsogram(input: String) = input.filter { it.isLetter() }
        .let { it.lowercase().toSet().size == it.length }

}
