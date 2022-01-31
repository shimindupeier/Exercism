
object WordCount {

    fun phrase(phrase: String): Map<String, Int> {
        val regexPunct = Regex("[!\"#\$%&()*+,./:;<=>?@\\\\^_`{|}~]")
        val removeNewLine = phrase.lowercase().replace("\\n".toRegex(), "")
        val removePunct = removeNewLine.replace(regexPunct, " ")
        val justAlphaNum = removePunct.split(" ")

        return justAlphaNum.filterNot { it.isBlank() }.groupingBy { it }.eachCount()
    }
}
