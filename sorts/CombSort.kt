package sorts

import sorts.SortUtils.less
import sorts.SortUtils.printArray
import sorts.SortUtils.swap

/**
 * Comb Sort algorithm implementation
 *
 *
 * Best-case performance O(n * log(n))
 * Worst-case performance O(n ^ 2)
 * Worst-case space complexity O(1)
 *
 *
 * Comb sort improves on bubble sort.
 *
 * Code idea from https://github.com/TheAlgorithms
 * @author Sandeep Roy (https://github.com/sandeeproy99)
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 * @author Bakirov Insaf (https://github.com/Insafprog)
 * @see BubbleSort
 *
 * @see SortAlgorithm
 */
object CombSort : SortAlgorithm {
    // To find gap between elements
    private fun nextGap(gap: Int): Int {
        // Shrink gap by Shrink factor
        var g = gap
        g = g * 10 / 13
        return if (g < 1) 1 else g
    }

    /**
     * Function to sort arr[] using Comb
     *
     * @return sorted array
     */
    override fun <T : Comparable<T>> Array<T>.sortAlgorithm(): Array<T> {
        val size = size

        // initialize gap
        var gap = size

        // Initialize swapped as true to make sure that loop runs
        var swapped = true

        // Keep running while gap is more than 1 and last iteration caused a swap
        while (gap != 1 || swapped) {
            // Find next gap
            gap = nextGap(gap)

            // Initialize swapped as false so that we can check if swap happened or not
            swapped = false

            // Compare all elements with current gap
            for (i in 0 until size - gap) {
                if (this[i + gap].less(this[i])) {
                    // Swap arr[i] and arr[i+gap]
                    swapped = swap(i, i + gap)
                }
            }
        }
        return this
    }

        // Driver method
    @JvmStatic
    fun main(args: Array<String>) {
        val array = arrayOf(8, 4, 1, 56, 3, -44, -1, 0, 36, 34, 8, 12, -66, -78, 23, -6, 28, 0)
        array.sortAlgorithm()
        println("sorted array")
        array.printArray()
    }
}