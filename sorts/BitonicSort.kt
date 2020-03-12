package sorts

import sorts.SortUtils.printArray
import sorts.SortUtils.swap

/**
 * @author Bakirov Insaf (https://github.com/Insafprog)
 * Code idea from https://github.com/TheAlgorithms
 *
 * Python program for Bitonic Sort. Note that this program
 */

object BitonicSort: SortAlgorithm {
    override fun <T: Comparable<T>> Array<T>.sortAlgorithm(): Array<T> {
        val low = 0
        val up = 1
        bitonicSort(low, size, up)
        return this
    }

    /*
    This function first produces a bitonic sequence by recursively
    sorting its two halves in opposite sorting orders, and then
    calls bitonicMerge to make them in the same order
    */

    private fun <T: Comparable<T>> Array<T>.bitonicSort(low: Int, cnt: Int, dire: Int) {
        if (cnt > 1) {
            val k = cnt / 2
            bitonicSort(low, k, 1)
            bitonicSort(low + k, k, 0)
            bitonicMerge(low, cnt, dire)
        }
    }

    /*
    It recursively sorts a bitonic sequence in ascending order,
    if dire = 1, and in descending order otherwise (means dire = 0).
    The sequence to be sorted starts at index position low,
    the parameter cnt is the number of elements to be sorted.
    */

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

    /*
    The parameter dir indicates the sorting direction, ASCENDING
    or DESCENDING; if (a[i] > a[j]) agrees with the direction,
    then a[i] and a[j] are interchanged.
    */

    private fun <T: Comparable<T>> Array<T>.compAndSwap(i: Int, j: Int, dire: Int) {
        if ((dire == 1 && this[i] > this[j]) || (dire == 0 && this[i] < this[j] ))
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