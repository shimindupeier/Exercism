import kotlin.math.pow

object ResistorColorTrio {

    fun text(vararg input: Color): String {

        val enumColor = Color.values().toList()
        val mainValueStr = "${enumColor.indexOf(input.component1())}${enumColor.indexOf(input.component2())}"
        val powerOf = enumColor.indexOf(input.component3()).toDouble()

        val exponentValue = 10.0.pow(powerOf).toInt()
        val decodedValue = mainValueStr.toInt() * exponentValue
        val chunks = decodedValue.toString().reversed().chunked(3)
        val mainValue = chunks.last().reversed()
        val unit = when (chunks.size) {
            1 -> Unit.OHMS.unitDesc
            2 -> Unit.KILOOHMS.unitDesc
            3 -> Unit.MEGAOHMS.unitDesc
            4 -> Unit.GIGAOHMS.unitDesc
            5 -> Unit.TERAOHMS.unitDesc
            6 -> Unit.PETAOHMS.unitDesc
            7 -> Unit.EXAOHMS.unitDesc
            else -> ""
        }
        return "$mainValue $unit"
    }
}
