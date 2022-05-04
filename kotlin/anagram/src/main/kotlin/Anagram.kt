class Anagram(private val source: String) {

    fun match(anagrams: Collection<String>): Set<String> = anagrams.asSequence()
        .filterNot { it.equals(source, true) }
        .filter { it.length == source.length }
        .filter { it.lowercase().toList().containsAll(source.lowercase().toList()) }
        .filter { item ->
            item.lowercase().groupBy { it } == source.lowercase().groupBy { it }
        }.toSet()
}
