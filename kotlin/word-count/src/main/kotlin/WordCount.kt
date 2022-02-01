
object WordCount {

    fun phrase(phrase: String): Map<String, Int> {
        val regexPunct = Regex("[!\"#\$%&()*+,./:;<=>?@^_`{|}~]|(?<=\\s)'|'(?=\\s)|'(?=\$)|\\n")
        val removePunct = phrase.lowercase().replace(regexPunct, " ")
        val justAlphaNum = removePunct.split("\\s".toRegex())

        return justAlphaNum.filterNot { it.isBlank() }.groupingBy { it }.eachCount()
    }
}
