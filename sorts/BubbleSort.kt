package sorts

import sorts.SortUtils.less
import sorts.SortUtils.printArray
import sorts.SortUtils.swap

/**
 * BubbleSort
 *
 * Code idea from https://github.com/TheAlgorithms
 */

object BubbleSort: SortAlgorithm {
    /**
     * This method implements the Generic Bubble Sort
     *
     * @author Varun Upadhyay (https://github.com/varunu28)
     * @author Podshivalov Nikita (https://github.com/nikitap492)
     * @author Bakirov Insaf (https://github.com/Insafprog)
     * Sorts the array in increasing order
     */
    override fun <T : Comparable<T>> Array<T>.sortAlgorithm(): Array<T> {
        val length = size
        for (i in 0 until length - 1) {
            var swapped = false
            for (j in 0 until length - 1 - i) {
                if (this[j].less(this[j + 1])) {
                    swap(j, j + 1)
                    swapped = true
                }
            }
            if (!swapped) {
                break
            }
        }
        return this
    }

    // Driver Program
    @JvmStatic
    fun main(args: Array<String>) {
        // Integer Input
        val integers = arrayOf(4, 23, 6, 78, 1, 54, 231, 9, 12)

        // Output => 231, 78, 54, 23, 12, 9, 6, 4, 1
        integers.sortAlgorithm().printArray()

        // String Input
        val strings = arrayOf("c", "a", "e", "b", "d")
        //Output => e, d, c, b, a
        strings.sortAlgorithm().printArray()
    }
}