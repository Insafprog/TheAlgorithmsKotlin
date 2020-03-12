package sorts

import sorts.SortUtils.less
import sorts.SortUtils.printArray
import sorts.SortUtils.swap

/**
 * Code idea from https://github.com/TheAlgorithms
 * @author Varun Upadhyay (https://github.com/varunu28)
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 * @author Bakirov Insaf (https://github.com/Insafprog)
 */
object SelectionSort : SortAlgorithm {
    /**
     * This method implements the Generic Selection Sort
     *
     * Sorts the array in increasing order
     */
    override fun <T : Comparable<T>> Array<T>.sortAlgorithm(): Array<T> {
        val n = size
        for (i in 0 until n - 1) {
            // Initial index of min
            var min = i
            for (j in i + 1 until n) {
                if (this[j].less(this[min])) {
                    min = j
                }
            }

            // Swapping if index of min is changed
            if (min != i) {
                swap(i, min)
            }
        }
        return this
    }

    // Driver Program
    @JvmStatic
    fun main(args: Array<String>) {
        val arr = arrayOf(4, 23, 6, 78, 1, 54, 231, 9, 12)

        // Output => 1 4 6 9 12 23 54 78 231
        arr.sortAlgorithm().printArray()

        // String Input
        val strings = arrayOf("c", "a", "e", "b", "d")

        //Output => a b c d e
        strings.sortAlgorithm().printArray()
    }
}