class CustomSet(vararg x: Int) {
    private val s = x.toMutableSet()

    // TODO: implement proper constructor
    fun isEmpty(): Boolean {
        return s.isEmpty()
    }

    fun isSubset(other: CustomSet): Boolean {
        return s.all { it in other }
    }

    fun isDisjoint(other: CustomSet): Boolean {
        return !s.any { other.contains(it) }
    }

    operator fun contains(other: Int): Boolean {
        return other in s
    }

    // https://stackoverflow.com/questions/39389003/kotlin-asterisk-operator-before-variable-name-or-spread-operator-in-kotlin
    fun intersection(other: CustomSet): CustomSet = CustomSet(*(s.intersect(other.s)).toIntArray())

    fun add(other: Int) {
        s.add(other)
    }

    override fun equals(other: Any?): Boolean {
        return if (other !is CustomSet) {
                false
            } else {
                s == other.s
        }
    }

    operator fun plus(other: CustomSet): CustomSet {
        return if (s.isEmpty() && other.isEmpty()) {
            CustomSet(*(emptySet<Int>().toIntArray()))
        } else {
            CustomSet(*(s + other.s).toIntArray())
        }
    }

    operator fun minus(other: CustomSet): CustomSet {
        return if (s.isEmpty()) {
            CustomSet(*(emptySet<Int>().toIntArray()))
        } else {
            CustomSet(*(s.filter { !other.contains(it) }.toIntArray()))
        }
    }

    override fun hashCode(): Int {
        return s.hashCode()
    }
}
