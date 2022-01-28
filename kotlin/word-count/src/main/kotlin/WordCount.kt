
object WordCount {

    fun phrase(phrase: String): Map<String, Int> {
        phrase.lowercase()
        return phrase.split(" ").groupingBy { it }.eachCount()
    }
}
