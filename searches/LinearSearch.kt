package searches

/**
 * Linear search is the easiest search algorithm
 * It works with sorted and unsorted arrays (an binary search works only with sorted array)
 * This algorithm just compares all elements of an array to find a value
 *
 *
 * Worst-case performance	O(n)
 * Best-case performance	O(1)
 * Average performance	O(n)
 * Worst-case space complexity
 *
 * Code idea from https://github.com/TheAlgorithms
 * @author Varun Upadhyay (https://github.com/varunu28)
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 * @author Bakirov Insaf (https://github.com/Insafprog)
 * @see BinarySearch
 *
 * @see SearchAlgorithm
 */
object LinearSearch : SearchAlgorithm {
    /**
     * Generic Linear search method
     *
     * @param key Key being searched for
     * @return Location of the key
     */
    override fun <T: Comparable<T>> Array<T>.findAlgorithm(key: T): Int {
        for ((i, v) in withIndex()) {
            if (v == key) {
                return i
            }
        }
        return -1
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