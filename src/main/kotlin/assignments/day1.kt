package assignments

import util.fetchTestData

fun runDay1_1(isMock: Boolean = true): Int {
    val regex = Regex("(\\d{1})(?:.*(\\d))?")

    return getData(isMock).fold(0) { acc, i ->
        val (first, last) = regex.find(i)!!.destructured.let { (first, last) -> first to last.ifEmpty { first } }
        acc + "$first$last".toInt()
    }
}

fun runDay1_2(isMock: Boolean = true): Int {
    val regex = Regex("(one|two|three|four|five|six|seven|eight|nine|\\d{1})(?:.*(one|two|three|four|five|six|seven|eight|nine|\\d))?")

    return getData2(isMock).fold(0) { acc, i ->
        val (first, last) = regex.find(i)!!.destructured.let { (first, last) -> first to last.ifEmpty { first } }
        acc + "${first.toDigit}${last.toDigit}".toInt()
    }
}

private val String.toDigit
    get() = when (this) {
        "one" -> 1
        "two" -> 2
        "three" -> 3
        "four" -> 4
        "five" -> 5
        "six" -> 6
        "seven" -> 7
        "eight" -> 8
        "nine" -> 9
        else -> toIntOrNull() ?: 0
    }

private fun getData(isMock: Boolean) = if (isMock) {
    """
        1abc2
        pqr3stu8vwx
        a1b2c3d4e5f
        treb7uchet
    """.trimIndent().split("\n")
} else fetchTestData(1)

private fun getData2(isMock: Boolean) = if (isMock) {
    """
two1nine
eightwothree
abcone2threexyz
xtwone3four
4nineeightseven2
zoneight234
7pqrstsixteen
    """.trimIndent().split("\n")
} else fetchTestData(1)