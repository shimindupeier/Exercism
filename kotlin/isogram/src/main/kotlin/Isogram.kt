object Isogram {

    fun isIsogram(input: String): Boolean {

        val newInput = input.lowercase().replace("[ -]".toRegex(), "")
        val strSet = newInput.toSet()

        return newInput.length == strSet.size
    }
}
