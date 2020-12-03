package ch.lihsmi.aoc2020.day01

class ExpenseReporter {

    fun calcExpenses(numbers: List<Int>): Int {
        for (number1 in numbers) {
            for (number2 in numbers) {
                if (number1 + number2 == 2020) {
                    println("Number $number1 and number $number2 equal " + (number1 + number2))
                    return number1 * number2
                }
            }
        }
        return -1
    }

    fun calc3Expenses(numbers: List<Int>): Int {
        for (number1 in numbers) {
            for (number2 in numbers) {
                for (number3 in numbers) {
                    if (number1 + number2 + number3 == 2020) {
                        println("Number $number1 and number $number2 and $number3 equal " + (number1 + number2 + number3))
                        return number1 * number2 * number3
                    }
                }
            }
        }
        return -1
    }

}
