class BankAccount {
    private var openingBalance: Long = 0
    private var accOpen = true

    val balance: Long
        get() {
            return if (accOpen)
                this.openingBalance
            else
                throw IllegalStateException()
        }

    fun adjustBalance(amount: Long){
        if (accOpen)
            openingBalance += amount
        else
            throw IllegalStateException()
    }

    fun close() {
        accOpen = false
    }
}
