class BankAccount {

    private var accOpen = true

    var balance: Long = 0
        get() {
            return if (accOpen)
                field
            else
                throw IllegalStateException()
        }

    fun adjustBalance(amount: Long){
        if (accOpen)
            this.balance += amount
        else
            throw IllegalStateException()
    }

    fun close() {
        accOpen = false
    }
}
