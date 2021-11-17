class CustomSet(vararg x: Int) {
    private val s = x.toSet()

    // TODO: implement proper constructor
    fun isEmpty(): Boolean {
        return s.isEmpty()
    }

    fun isSubset(other: CustomSet): Boolean {
        return s.all { it in other }
    }

    fun isDisjoint(other: CustomSet): Boolean {
        TODO("Implement this function to complete the task")
    }

    operator fun contains(other: Int): Boolean {
        return other in s
    }

    fun intersection(other: CustomSet): CustomSet {
        TODO("Implement this function to complete the task")
    }

    fun add(other: Int) {
        TODO("Implement this function to complete the task")
    }

    override fun equals(other: Any?): Boolean {
        TODO("Implement this function to complete the task")
    }

    operator fun plus(other: CustomSet): CustomSet {
        TODO("Implement this function to complete the task")
    }

    operator fun minus(other: CustomSet): CustomSet {
        TODO("Implement this function to complete the task")
    }
}
