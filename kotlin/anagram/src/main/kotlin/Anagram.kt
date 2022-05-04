class Anagram(private val source: String) {

    fun match(anagrams: Collection<String>): Set<String> {
        val filterAnagram = anagrams.filterNot { it.equals(source, true) }
            .filter { it.length == source.length }
            .filter { it.lowercase().toList().containsAll(source.lowercase().toList()) }
            .filter { item ->
                val tmp = item.lowercase().groupBy { it }
                tmp == source.lowercase().groupBy { it }
            }.toSet()

        return filterAnagram
    }
}
