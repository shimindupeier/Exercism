import java.time.LocalDateTime
import java.time.LocalDate

class Gigasecond(moment: LocalDateTime, dummy: LocalDateTime?) {

    constructor(localDate: LocalDate): this(localDate.atStartOfDay(), LocalDateTime.now())

    val date: LocalDateTime by lazy { moment.plusSeconds(1000000000) }
}
