package util

import java.net.URL

fun fetchTestData(day: Int) = with(URL("https://adventofcode.com/2023/day/$day/input").openConnection()) {
    setRequestProperty("cookie", "_ga=GA1.2.672924802.1701427540; _gid=GA1.2.1238437817.1701427540; session=53616c7465645f5f5ad720a38515b4d4ae018c0bd5d65e5c44090b28d5e913a762926759438666c833adf125bba4ff9744b47e2e64ec25c2a1b4fcc4f0f1ad5a; _ga_MHSNPJKWC7=GS1.2.1701427540.1.1.1701427592.0.0.0")
    try {
        getInputStream().bufferedReader().use {
            it.lines().toList()
        }
    } catch (e: Exception) {
        e.printStackTrace()
        emptyList<String>()
    }
}
