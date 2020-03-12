package sorts

import sorts.SortUtils.less
import sorts.SortUtils.printArray
import sorts.SortUtils.swap

/**
 * Code idea from https://github.com/TheAlgorithms
 * @author Varun Upadhyay (https://github.com/varunu28)
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 * @author Bakirov Insaf (https://github.com/Insafprog)
 * @see SortAlgorithm
 */
object QuickSort: SortAlgorithm {
    /**
     * This method implements the Generic Quick Sort
     *
     * Sorts the array in increasing order
     */
    override fun <T: Comparable<T>> Array<T>.sortAlgorithm(): Array<T> {
        doSort(0, size - 1)
        return this
    }

    /**
     * The sorting process
     *
     * @param left  The first index of an array
     * @param right The last index of an array
     */
    private fun <T : Comparable<T>> Array<T>.doSort(left: Int, right: Int) {
        if (left < right) {
            val pivot = randomPartition(left, right)
            doSort(left, pivot - 1)
            doSort(pivot, right)
        }
    }

    /**
     * Ramdomize the array to avoid the basically ordered sequences
     *
     * @param left  The first index of an array
     * @param right The last index of an array
     * @return the partition index of the array
     */
    private fun <T : Comparable<T>> Array<T>.randomPartition(left: Int, right: Int): Int {
        val randomIndex = left + (Math.random() * (right - left + 1)).toInt()
        swap(randomIndex, right)
        return partition(left, right)
    }

    /**
     * This method finds the partition index for an array
     *
     * @param left  The first index of an array
     * @param right The last index of an array
     * Finds the partition index of an array
     */
    private fun <T : Comparable<T>> Array<T>.partition(left: Int, right: Int): Int {
        var l = left
        var r = right
        val mid = (l + r) / 2
        val pivot = this[mid]
        while (l <= r) {
            while (this[l].less(pivot)) {
                ++l
            }
            while (pivot.less(this[r])) {
                --r
            }
            if (l <= r) {
                swap(l, r)
                ++l
                --r
            }
        }
        return l
    }

    // Driver Program
    @JvmStatic
    fun main(args: Array<String>) {

        // For integer input
        val array = arrayOf(3, 4, 1, 32, 0, 1, 5, 12, 2, 5, 7, 8, 9, 2, 44, 111, 5)
        //Output => 0 1 1 2 2 3 4 5 5 5 7 8 9 12 32 44 111
        array.sortAlgorithm().printArray()
        val stringArray = arrayOf("c", "a", "e", "b", "d")
        //Output => a	b	c	d	e
        stringArray.sortAlgorithm().printArray()
    }
}