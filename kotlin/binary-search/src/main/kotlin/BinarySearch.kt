object BinarySearch {
    fun search(list: List<Int>, item: Int): Int {
        var left = 0
        var right = list.size - 1

        while (left <= right) {
            val mid = (left + right)/2
            val target = list[(left + right)/2]
            if (item == target)
                return mid
            else if (item < target)
                right = mid.dec()
            else if (item > target)
                left = mid.inc()
        }
        throw NoSuchElementException()
    }
}
