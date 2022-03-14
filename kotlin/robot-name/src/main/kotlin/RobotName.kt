class Robot {
    private var prevName = ""

    init {
        println("prev_name: $prevName")
        println("name: $name")
    }

    val name: String
        get() = if (prevName.isEmpty()) {
            ('A'..'Z').random().toString() +
                    ('A'..'Z').random().toString() +
                    ('0'..'9').random().toString() +
                    ('0'..'9').random().toString() +
                    ('0'..'9').random().toString()
        } else prevName

    init {
        prevName = name
        println("prev_name1: $prevName")
        println("name1: $name")
    }

    fun reset() {
        prevName = ""
    }
}
