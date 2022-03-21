class BankAccount {
    private var openingBalance: Long = 0

    val balance: Long
        get() = this.openingBalance

    fun adjustBalance(amount: Long){
        openingBalance += amount
    }

    fun close() {
        TODO("Implement the function to complete the task")
    }
}
