class Anagram(val source: String) {

    fun match(anagrams: Collection<String>): Set<String> {
        val filterAnagram = anagrams.filterNot { it.equals(source, true)}
            .filter { it.length == source.length }
            .filter { it.lowercase().toList().containsAll(source.lowercase().toList()) }

        val sourceGrouping = source.lowercase().groupBy { it }
        val anagramGrouping = filterAnagram.filter { item ->
            val tmp = item.lowercase().groupBy { it }
            tmp == sourceGrouping }

        return anagramGrouping.toSet()
    }
}
