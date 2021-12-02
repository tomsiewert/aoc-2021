fun main() {
    fun part1(input: List<String>): Int {
        val input = input.map { it.toInt() }
        var count =  0

        for (i in 1 until input.size) {
            if (input[i-1] < input[i]) count++
        }
        return count
    }

    fun part2(input: List<String>): Int {
        val input = input.map { it.toInt() }
        var count = 0
        var lastSum = 0

        input.windowed(3).forEach { window ->
            val sum = window.sum()
            if (sum > lastSum && lastSum != 0) {
                count++
            }
            lastSum = sum
        }
        return count
    }

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}