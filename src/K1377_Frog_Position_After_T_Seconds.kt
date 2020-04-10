import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

fun frogPosition(n: Int, edges: Array<IntArray>, t: Int, target: Int): Double {
    //build graph
    //bfs until find target
    var graph: Map<Int, ArrayList<Int>> = buildGraph(edges)
    var queue = LinkedList<Int>()
    var seen = HashSet<Int>()
    queue.add(edges[0][0])
    var divide = 1.0
    while (!queue.isEmpty()) {
        var size = queue.size
        for (i in 1..size) {
            var curr = queue.remove()
            if (curr == target) {
                var divideSize = size.toDouble()
                return (divide / divideSize)
            } else {
                graph.get(curr)?.let { queue.addAll(it) }
            }
        }
        divide /= size
    }

    return 0.0
}

fun buildGraph(edges: Array<IntArray>): HashMap<Int, ArrayList<Int>> {
    var map = HashMap<Int, ArrayList<Int>>()
    for (arr in edges) {
        if (map[arr[0]] != null) {
            map[arr[0]]?.add(arr[1])
        } else {
            var list = ArrayList<Int>()
            list.add(arr[1])
            map[arr[0]] = list
        }
    }
    return map
}

fun main() {
    frogPosition(7, arrayOf(intArrayOf(1, 2), intArrayOf(1, 3), intArrayOf(1, 7), intArrayOf(2, 4), intArrayOf(2, 6), intArrayOf(3, 5)), 2, 4)
}