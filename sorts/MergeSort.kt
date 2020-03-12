package sorts

import sorts.SortUtils.printArray

/**
 * This method implements the Generic Merge Sort
 *
 * Code idea from https://github.com/TheAlgorithms
 * @author Varun Upadhyay (https://github.com/varunu28)
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 * @author Bakirov Insaf (https://github.com/Insafprog)
 * @see SortAlgorithm
 */
object MergeSort : SortAlgorithm {
    /**
     * This method implements the Generic Merge Sort
     *
     * @param <T>      Comparable class
     * @return sorted array
    </T> */
    override fun <T : Comparable<T>> Array<T>.sortAlgorithm(): Array<T> = doSort(0, size - 1)

    /**
     * @param left  The first index of the array
     * @param right The last index of the array
     * Recursively sorts the array in increasing order
     */
    private fun <T : Comparable<T>> Array<T>.doSort(left: Int, right: Int): Array<T> {
        if (left < right) {
            val mid = left + (right - left) / 2
            doSort(left, mid)
            doSort(mid + 1, right)
            merge(left, mid, right)
        }
        return this
    }

    /**
     * This method implements the merge step of the merge sort
     *
     * @param left  The first index of the array
     * @param mid   The middle index of the array
     * @param right The last index of the array
     * merges two parts of an array in increasing order
     */
    private fun <T : Comparable<T>> Array<T>.merge(left: Int, mid: Int, right: Int) {
        val length = right - left + 1
        val temp = clone()
        var i = left
        var j = mid + 1
        var k = 0
        while (i <= mid && j <= right) {
            if (this[i] <= this[j]) {
                temp[k++] = this[i++]
            } else {
                temp[k++] = this[j++]
            }
        }
        while (i <= mid) {
            temp[k++] = this[i++]
        }
        while (j <= right) {
            temp[k++] = this[j++]
        }
        temp.copyInto(this, left, 0, length)
    }

    // Driver program
    @JvmStatic
    fun main(args: Array<String>) {

        // Integer Input
        val arr = arrayOf(4, 23, 6, 78, 1, 54, 231, 9, 12)
        // Output => 1	   4  	 6	9	12	23	54	78	231
        arr.sortAlgorithm().printArray()

        // String Input
        val stringArray = arrayOf("c", "a", "e", "b", "d")
        //Output => a	b	c	d	e
        stringArray.sortAlgorithm().printArray()
    }
}