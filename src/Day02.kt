fun main() {
    fun part1(input: List<String>): Int {
        var horizontal = 0
        var depth = 0

        input.forEach {
            when (it.substringBefore(" ")) {
                "up" -> depth -= it.substringAfter(" ").toInt()
                "down" -> depth += it.substringAfter(" ").toInt()
                "forward" -> horizontal += it.substringAfter(" ").toInt()
            }
        }

        return depth * horizontal
    }

    fun part2(input: List<String>): Int {
        var horizontal = 0
        var depth = 0
        var aim = 0

        input.forEach {
            when (it.substringBefore(" ")) {
                "up" -> aim -= it.substringAfter(" ").toInt()
                "down" -> aim += it.substringAfter(" ").toInt()
                "forward" -> {
                    horizontal += it.substringAfter(" ").toInt()
                    depth += aim * it.substringAfter(" ").toInt()
                }
            }
        }
        return horizontal * depth
    }

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
