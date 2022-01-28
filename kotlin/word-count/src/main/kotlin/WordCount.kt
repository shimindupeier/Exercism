
object WordCount {

    fun phrase(phrase: String): Map<String, Int> {
        phrase.lowercase()
        val regex = Regex("\\s|\\p{Punct}")
        return phrase.split(regex).groupingBy { it }.eachCount()
    }
}
