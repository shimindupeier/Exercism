class BankAccount {

    private var accOpen = true

    var balance: Long = 0
        get() {
            check(accOpen)
            return field
        }

    @Synchronized
    fun adjustBalance(amount: Long) {
        check(accOpen)
        this.balance += amount
    }

    fun close() {
        accOpen = false
    }
}
