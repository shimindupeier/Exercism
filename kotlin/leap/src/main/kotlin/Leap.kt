data class Year(val year: Int) {

    private val yr = this.year

    val isLeap: Boolean =
      if (yr.rem(100 ) == 0) {
          yr.rem(400) == 0
      } else yr.rem(4) == 0
}
