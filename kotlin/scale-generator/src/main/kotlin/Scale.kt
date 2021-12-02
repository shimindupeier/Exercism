class Scale(private val tonic: String) {

    private val chromaticScaleSharp = listOf("C","C#","D","D#","E","F","F#","G","G#","A","A#","B","C","C#","D","D#","E","F","F#","G","G#","A","A#","B")
    private val chromaticScaleFlat = listOf("C","Db","D","Eb","E","F","Gb","G","Ab","A","Bb","B","C","Db","D","Eb","E","F","Gb","G","Ab","A","Bb","B")
    private val useSharp = listOf("G","D","A","E","B","F#","C","e","b","f#","c#","g#","d#")

    fun chromatic(): List<String> {
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
        val scale: MutableList<String> = mutableListOf()
        var startIndex: Int

        if (tonic in useSharp) {
            startIndex = chromaticScaleSharp.indexOf(tonic.replaceFirstChar { it.uppercase() })
            scale.add(tonic.replaceFirstChar { it.uppercase() })
            for (i in intervalList.dropLast(1).indices) {
                when (intervalList[i]) {
                    "M" -> startIndex += 2
                    "m" -> startIndex += 1
                    "A" -> startIndex += 3
                }
                scale.add(chromaticScaleSharp[startIndex])
//                if (intervalList[i] == "M") {
//                    startIndex += 2
//                    scale.add(chromaticScaleSharp[startIndex])
//                } else if (intervalList[i] == "m") {
//                    startIndex += 1
//                    scale.add(chromaticScaleSharp[startIndex])
//                } else if (intervalList[i] == "A") {
//                    startIndex += 3
//                    scale.add(chromaticScaleSharp[startIndex])
//                }
            }
        } else {
            startIndex = chromaticScaleFlat.indexOf(tonic.replaceFirstChar { it.uppercase() })
            scale.add(tonic.replaceFirstChar { it.uppercase() })
            for (i in intervalList.dropLast(1).indices) {
                if (intervalList[i] == "M") {
                    startIndex += 2
                    scale.add(chromaticScaleFlat[startIndex])
                } else if (intervalList[i] == "m") {
                    startIndex += 1
                    scale.add(chromaticScaleFlat[startIndex])
                } else if (intervalList[i] == "A") {
                    startIndex += 3
                    scale.add(chromaticScaleFlat[startIndex])
                }
            }
        }

        return scale
    }
}
