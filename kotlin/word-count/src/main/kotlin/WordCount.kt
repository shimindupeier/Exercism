
object WordCount {

    fun phrase(phrase: String): Map<String, Int> {

        val regexPunctuation = Regex("[!\"#\$%&()*+,./:;<=>?@^_`{|}~]|(?<=\\s)'|'(?=\\s)|'(?=\$)|\\n")
        val removePunctuation = phrase.lowercase().replace(regexPunctuation, " ")
        val justAlphaNum = removePunctuation.split("\\s".toRegex())

        return justAlphaNum.filterNot { it.isBlank() }.groupingBy { it }.eachCount()
    }
}
