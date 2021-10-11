object Acronym {
    fun generate(phrase: String) : String {
        val tmp = phrase.replace(Regex("[_']"), "").split(" ", "-")
        return tmp.filter { it.isNotBlank() }.map { it.first().toUpperCase() }.joinToString("")
    }
}
