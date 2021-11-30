class Scale(private val tonic: String) {

    private val chromaticScaleSharp = listOf("C","C#","D","D#","E","F","F#","G","G#","A","A#","B","C","C#","D","D#","E","F","F#","G","G#","A","A#","B")
    private val chromaticScaleFlat = listOf("C","Db","D","Eb","E","F","Gb","G","Ab","A","Bb","B","C","Db","D","Eb","E","F","Gb","G","Ab","A","Bb","B")
    private val useSharp = listOf("G","D","A","E","B","F#","C","e","b","f#","c#","g#","d#")
//    private val useFlat = listOf("F","Bb","Eb","Ab","Db","Gb","d","g","c","f","bb","eb")

    fun chromatic(): List<String> {
//        val startIndex: Int
//        val endIndex: Int

        return if (tonic in useSharp) {
            val startIndex = chromaticScaleSharp.indexOf(tonic)
            val endIndex = startIndex + 12
            chromaticScaleSharp.subList(startIndex, endIndex)
        } else {
            val startIndex = chromaticScaleFlat.indexOf(tonic)
            val endIndex = startIndex + 12
            chromaticScaleFlat.subList(startIndex, endIndex)
        }
    }

    fun interval(intervals: String): List<String> {
        val intervalList = intervals.split("(?<=\\D)(?=\\D)".toRegex())
        val scale: MutableList<String> = mutableListOf(tonic)
        var startIndex = chromaticScaleSharp.indexOf(tonic)

        for (i in intervalList.dropLast(1).indices) {
            if (intervalList[i] == "M") {
                startIndex += 2
                scale.add(chromaticScaleSharp[startIndex])
            } else if (intervalList[i] == "m") {
                startIndex += 1
                scale.add(chromaticScaleSharp[startIndex])
            }
        }
        return scale
    }
}
