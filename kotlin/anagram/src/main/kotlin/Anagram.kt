class Anagram(val source: String) {

    fun match(anagrams: Collection<String>): Set<String> {
        //check for edge cases rid of words same as source
        //check for when there is no anagram
        val filterAnagram = anagrams.filterNot { it.equals(source, true)}
            .filter { it.length == source.length }
            .filter { it.lowercase().toSet() == source.lowercase().toSet() }

        return filterAnagram.toSet()
    }
}
