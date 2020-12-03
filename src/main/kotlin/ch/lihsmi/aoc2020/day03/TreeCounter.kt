package ch.lihsmi.aoc2020.day03

class TreeCounter(val map: List<String>) {

    fun count(stepDown: Int, stepRight: Int): Int {
        var currDown = 0
        var currLeft = 0
        var treeCount = 0
        while (currDown < map.size) {
            if (map[currDown].toCharArray()[currLeft.rem(map[0].length)] == '#') {
                treeCount++
            }
            currDown += stepDown
            currLeft += stepRight
        }
        return treeCount
    }

}
