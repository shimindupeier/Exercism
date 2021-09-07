import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

class Gigasecond {
    private var localDateTime: LocalDateTime = LocalDateTime.now()

    constructor(localDateTime: LocalDateTime, dummy: LocalDateTime?) {
        this.localDateTime = localDateTime
    }
    // TODO: Implement proper constructor
    constructor(localDate: LocalDate) {this.localDateTime = localDate.atStartOfDay()}

    val date: LocalDateTime by lazy { localDateTime.plusSeconds(1000000000) }
}
