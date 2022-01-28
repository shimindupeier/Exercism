
object WordCount {

    fun phrase(phrase: String): Map<String, Int> {
        phrase.lowercase()
        val regexPunct = Regex("\\p{P}")
        val removeNewLine = phrase.replace("\\n".toRegex(), "")
        val removePunct = removeNewLine.replace(regexPunct, " ")
        val justAlphaNum = removePunct.split(" ")
        return justAlphaNum.filterNot { it.isBlank() }.groupingBy { it }.eachCount()
    }
}
