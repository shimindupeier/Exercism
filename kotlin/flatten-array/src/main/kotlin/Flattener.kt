object Flattener {
    fun flatten(source: Collection<Any?>): List<Any> {

        return source.mapNotNull {
            when (it) {
                is Collection<*> -> flatten(it)
                is Int -> listOf(it)
                else -> null
            }
        }.flatten()
    }
}
