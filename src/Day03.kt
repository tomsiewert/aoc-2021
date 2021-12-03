fun main() {
    fun part1(input: List<String>): Int {
        val common = CharArray(input.minOfOrNull { it.length } ?: 0) { i ->
            input.groupingBy { it[i] }.eachCount().entries.maxByOrNull { it.value }!!.key
        }
        val gamma = common.concatToString().toInt(2)
        common.forEachIndexed{ i, c -> common[i] = (c.code xor 1).toChar() }
        val epsilon = common.concatToString().toInt(2)
        return gamma * epsilon
    }

    fun part2(input: List<String>): Int {
        val oxygen = input.toMutableList()
        val co2 = input.toMutableList()
        for (i in 0 until (input.minOfOrNull { it.length } ?: 0)) {
            val common = oxygen.groupingBy { it[i] }
                .eachCount().entries
                .maxWithOrNull(compareBy({ it.value }, { it.key }))!!.key
            val uncommon = co2.groupingBy { it[i] }
                .eachCount().entries
                .minWithOrNull(compareBy({ it.value }, { it.key }))!!.key
            oxygen.retainAll { it[i] == common }
            co2.retainAll { it[i] == uncommon }
        }
        return oxygen.single().toInt(2) * co2.single().toInt(2)
    }

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}