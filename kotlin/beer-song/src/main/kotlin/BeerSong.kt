object BeerSong {
    fun verses(startBottles: Int, takeDown: Int): String {
        var song = ""
        for (i in startBottles downTo takeDown) {
            song += verseLyrics(i, i-1)
            if (i > takeDown) song += "\n"
        }
        return song
    }
}

fun verseLyrics(bottleCount: Int, bottleLeft: Int): String {
    return when (bottleCount) {
        in (2..99) -> "$bottleCount bottles of beer on the wall, $bottleCount bottles of beer." +
                "\nTake one down and pass it around, $bottleLeft bottle${if (bottleLeft > 1) "s" else ""} of beer on the wall.\n"
        1 -> "$bottleCount bottle of beer on the wall, $bottleCount bottle of beer." +
                "\nTake it down and pass it around, no more bottles of beer on the wall.\n"
        else -> "No more bottles of beer on the wall, no more bottles of beer." +
                "\nGo to the store and buy some more, 99 bottles of beer on the wall.\n"
    }
}