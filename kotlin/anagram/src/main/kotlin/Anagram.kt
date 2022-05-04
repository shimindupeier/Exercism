class Anagram(private val source: String) {

    fun match(anagrams: Collection<String>): Set<String> = anagrams.asSequence()
        .filter { !it.equals(source, true) && it.length == source.length}
        .filter { item -> item.lowercase().groupBy { it } == source.lowercase().groupBy { it } }
        .toSet()
}
