package sorts

import sorts.SortUtils.printArray
import sorts.SortUtils.swap

object BitonicSort: SortAlgorithm {
    override fun <T: Comparable<T>> Array<T>.sortAlgorithm(): Array<T> {
        val low = 0
        val up = 1
        bitonicSort(low, size, up)
        return this
    }

    private fun <T: Comparable<T>> Array<T>.bitonicSort(low: Int, cnt: Int, dire: Int) {
        if (cnt > 1) {
            val k = cnt / 2
            bitonicSort(low, k, 1)
            bitonicSort(low + k, k, 0)
            bitonicMerge(low, cnt, dire)
        }
    }

    private fun <T: Comparable<T>> Array<T>.bitonicMerge(low: Int, cnt: Int, dire: Int) {
        if (cnt > 1) {
            val k = cnt / 2
            for (i in low..low + k) {
                compAndSwap(i, i + k, dire)
            }
            bitonicMerge(low, k, dire)
            bitonicMerge(low + k, k, dire)
        }
    }

    private fun <T: Comparable<T>> Array<T>.compAndSwap(i: Int, j: Int, up: Int) {
        if ((up == 1 && this[i] > this[j]) || (up == 0 && this[i] < this[j] ))
            swap(i, j)
    }
    @JvmStatic
    fun main(args: Array<String>) {
        // Integer Input
        val integers = arrayOf(4, 23, 6, 78, 1, 54, 231, 9, 12)

        // print a sorted array
        integers.sortAlgorithm().printArray()

        // String Input
        val strings = arrayOf("c", "a", "e", "b", "d")

        strings.sortAlgorithm().printArray()
    }
}