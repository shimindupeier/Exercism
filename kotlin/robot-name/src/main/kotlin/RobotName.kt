class Robot {
    private var prevName = ""

    companion object {
        val generatedNames = mutableSetOf<String>()
    }

    private fun generateName() =
            ('A'..'Z').random().toString() +
                    ('A'..'Z').random().toString() +
                    ('0'..'9').random().toString() +
                    ('0'..'9').random().toString() +
                    ('0'..'9').random().toString()

    private fun checkUniqueName(): String {
        var generatedName = generateName()
        while (generatedNames.contains(generatedName)) {
            generatedName = generateName()
        }
        generatedNames.add(generatedName)
        return generatedName
    }

    val name: String
        get() = if (prevName.isEmpty()) {
            checkUniqueName()
        } else prevName

    init {
        prevName = name
    }

    fun reset() {
        prevName = ""
    }
}
