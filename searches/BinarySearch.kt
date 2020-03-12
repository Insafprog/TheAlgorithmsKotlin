package searches

/**
 * Binary search is one of the most popular algorithms
 * The algorithm finds the position of a target value within a sorted array
 *
 * Worst-case performance	O(log n)
 * Best-case performance	O(1)
 * Average performance	O(log n)
 * Worst-case space complexity	O(1)
 *
 *
 * Code idea from https://github.com/TheAlgorithms
 * @author Varun Upadhyay (https://github.com/varunu28)
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 * @author Bakirov Insaf (https://github.com/Insafprog)
 *
 * @see SearchAlgorithm
 *
 */
object BinarySearch :SearchAlgorithm {
    /**
     *
     * @param key is an element which should be found
     * @param <T> is any comparable type
     * @return index of the element
    </T> */
    override fun <T: Comparable<T>> Array<T>.findAlgorithm(key: T): Int {
        return binarySearch(key, 0, size)
    }

    /**
     * This method implements the Generic Binary Search
     *
     * @param key The number you are looking for
     * @param left The lower bound
     * @param right The  upper bound
     * @return the location of the key
     */
    private fun <T : Comparable<T>> Array<T>.binarySearch(key: T, left: Int, right: Int): Int {
        if (right < left) return -1 // this means that the key not found

        // find median
        val median = left + right ushr 1
        val comp = key.compareTo(this[median])
        return when {
            comp == 0 -> median
            comp < 0 -> binarySearch(key, left, median - 1)
            else -> binarySearch(key, median + 1, right)
        }
    }

    // Driver Program
    @JvmStatic
    fun main(args: Array<String>) {
        // Just generate data
        val size = 100
        val maxElement = 100000
        val integers = Array(size) { _ -> (0..maxElement).random() }.sortedArray()

        // The element that should be found
        val shouldBeFound = integers[(0 until size).random()]

        val atIndex = integers.findAlgorithm(shouldBeFound)
        println("Should be found: $shouldBeFound. Found ${integers[atIndex]} at index $atIndex. An array length $size")
        val toCheck = integers.binarySearch(shouldBeFound)
        println("Found by system method at an index: $toCheck. Is equal: ${toCheck == atIndex}")
    }
}