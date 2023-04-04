import java.time.LocalDate

class Expense(var amount: Double, var description: String, var date: LocalDate) {
    override fun toString(): String {
        return "$date - $description: $$amount"
    }
}

class ExpenseTracker {
    var expenses: MutableList<Expense> = mutableListOf()

    fun addExpense(amount: Double, description: String, date: LocalDate) {
        val expense = Expense(amount, description, date)
        expenses.add(expense)
        println("Expense added: $expense")
    }

    fun viewExpenses() {
        if (expenses.isEmpty()) {
            println("No expenses to display.")
        } else {
            println("Expenses:")
            expenses.forEach { expense -> println(expense) }
        }
    }

    fun deleteExpense(index: Int) {
        if (index < 0 || index >= expenses.size) {
            println("Invalid index.")
        } else {
            val expense = expenses.removeAt(index)
            println("Expense deleted: $expense")
        }
    }
}

fun main() {
    val expenseTracker = ExpenseTracker()

    while (true) {
        println("Enter an option:")
        println("1. Add expense")
        println("2. View expenses")
        println("3. Delete expense")
        println("4. Exit")

        val option = readLine()?.toIntOrNull()

        when (option) {
            1 -> {
                print("Enter amount: ")
                val amount = readLine()?.toDoubleOrNull() ?: continue
                print("Enter description: ")
                val description = readLine() ?: continue
                print("Enter date (YYYY-MM-DD): ")
                val dateString = readLine() ?: continue
                val date = LocalDate.parse(dateString)
                expenseTracker.addExpense(amount, description, date)
            }
            2 -> {
                expenseTracker.viewExpenses()
            }
            3 -> {
                print("Enter index of expense to delete: ")
                val index = readLine()?.toIntOrNull()?.minus(1) ?: continue
                expenseTracker.deleteExpense(index)
            }
            4 -> {
                println("Goodbye!")
                return
            }
            else -> {
                println("Invalid option.")
            }
        }
    }
}
