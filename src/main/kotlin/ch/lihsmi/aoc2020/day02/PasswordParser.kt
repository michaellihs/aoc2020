package ch.lihsmi.aoc2020.day02

class PasswordParser {

    class PasswordRule(val min: Int, val max: Int, val char: Char, val password: String) {
        fun isValid(): Boolean {
            val count = password.count{ char.toString().contains(it) }
            return count in min..max
        }

        fun isValidByPos(): Boolean {
            if ((password[min - 1] == char).xor(password[max - 1] == char)) {
                println("$min-$max $char: $password fulfils the position rule")
                return true
            }
            return false
        }

    }

    fun parse(pwdRules: List<String>): List<PasswordRule> {
        val regex = """(\d+)\-(\d+) (.)\: (.+)""".toRegex()
        val result = mutableListOf<PasswordRule>()

        for (pwdRule in pwdRules) {
            var matchResult = regex.find(pwdRule)
            val min = matchResult!!.groups[1]!!.value.toString().toInt()
            val max = matchResult.groups[2]!!.value.toString().toInt()
            val char = matchResult.groups[3]!!.value.toString().toCharArray()[0]
            val password = matchResult.groups[4]!!.value.toString()

            result.add(PasswordRule(min, max, char, password))
        }

        return result
    }

    fun countValid(pwdRules: List<PasswordRule>): Int {
        var result = 0
        for (pwdRule in pwdRules) {
            if (pwdRule.isValid()) {
                result++
            }
        }
        return result
    }

    fun countValidByPos(pwdRules: List<PasswordRule>): Int {
        var result = 0
        for (pwdRule in pwdRules) {
            if (pwdRule.isValidByPos()) {
                result++
            }
        }
        return result
    }

}
