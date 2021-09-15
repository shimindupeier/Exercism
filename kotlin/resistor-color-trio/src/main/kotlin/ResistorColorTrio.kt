import kotlin.math.pow

object ResistorColorTrio {

    fun text(vararg input: Color): String {

        val enumColor = Color.values().toList()
        val mainValue = "${enumColor.indexOf(input.component1())}${enumColor.indexOf(input.component2())}"
        val thirdValue = enumColor.indexOf(input.component3()).toDouble()

        val trailingZeros = 10.0.pow(thirdValue).toInt()
        val decodedValue = mainValue.toInt() * trailingZeros
        val chunks = decodedValue.toString().reversed().chunked(3)
        return when (chunks.size){
            1 -> "${chunks.last().reversed()} ${Unit.OHMS.unitDesc}"
            2 -> "${chunks.last().reversed()} ${Unit.KILOOHMS.unitDesc}"
            3 -> "${chunks.last().reversed()} ${Unit.MEGAOHMS.unitDesc}"
            4 -> "${chunks.last().reversed()} ${Unit.GIGAOHMS.unitDesc}"
            5 -> "${chunks.last().reversed()} ${Unit.TERAOHMS.unitDesc}"
            6 -> "${chunks.last().reversed()} ${Unit.PETAOHMS.unitDesc}"
            7 -> "${chunks.last().reversed()} ${Unit.EXAOHMS.unitDesc}"
            else -> ""
        }
    }
}
