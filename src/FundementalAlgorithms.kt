import java.util.Collections.swap

fun bubbleSort(list: MutableList<Int>) {
    for (i in 0 until list.size) {
        for (j in i + 1 until list.size) {
            if (list[i] > list[j]) {
                //swap list[i], list[j]
                swap(list, i, j)
            }
        }
    }
    println(list)
}

fun insertSort(list: MutableList<Int>) {
    for (i in 1 until list.size) {
        for (j in i downTo 1) {
            if (list[j] < list[j - 1]) {
                swap(list, j, j - 1)
            } else {
                break
            }
        }
    }
    println(list)
}

//Todo: mergeSort, quickSort, bucketSort

fun main() {
    bubbleSort(mutableListOf(4,5,3,1,2))
    insertSort(mutableListOf(4,5,3,1,2))
}