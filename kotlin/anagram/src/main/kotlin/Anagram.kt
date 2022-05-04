class Anagram(private val source: String) {

    fun match(anagrams: Collection<String>): Set<String> = anagrams.asSequence()
        .filter { item ->
            !item.equals(source, true) && item.lowercase().groupBy { it } == source.lowercase().groupBy { it }
        }.toSet()
}
