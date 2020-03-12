package sorts

import sorts.SortUtils.less
import sorts.SortUtils.printArray

/**
 * Code idea from https://github.com/TheAlgorithms
 * @author Varun Upadhyay (https://github.com/varunu28)
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 * @author Bakirov Insaf (https://github.com/Insafprog)
 */

object InsertionSort: SortAlgorithm {
    /**
     * This method implements the Generic Insertion Sort
     * Sorts the array in increasing order
     */
    override fun <T : Comparable<T>> Array<T>.sortAlgorithm(): Array<T> {

        for (j in 1 until size) {

            // Picking up the key(Card)
            val key = this[j]
            var i = j - 1
            while (i >= 0 && key.less(this[i])) {
                this[i + 1] = this[i]
                i--
            }
            // Placing the key (Card) at its correct position in the sorted subarray
            this[i + 1] = key
        }
        return this
    }

    // Driver Program
    @JvmStatic
    fun main(args: Array<String>) {
        // Integer Input
        val integers = arrayOf(4, 23, 6, 78, 1, 54, 231, 9, 12)
        // Output => 1 4 6 9 12 23 54 78 231
        integers.sortAlgorithm().printArray()

        // String Input
        val strings = arrayOf("c", "a", "e", "b", "d")
        //Output => a	b	c	d	e
        strings.sortAlgorithm().printArray()
    }
}