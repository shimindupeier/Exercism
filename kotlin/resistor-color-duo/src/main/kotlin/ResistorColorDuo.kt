object ResistorColorDuo {

    fun value(vararg colors: Color): Int {
        val enumColor = Color.values().toList()
        return "${enumColor.indexOf(colors.component1())}${enumColor.indexOf(colors.component2())}".toInt()
    }
}
