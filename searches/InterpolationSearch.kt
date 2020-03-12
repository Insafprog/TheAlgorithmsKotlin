package searches

/**
 * Interpolation search algorithm implementation
 *
 *
 * Worst-case performance	 O(n)
 * Best-case performance	O(1)
 * Average performance	O(log(log(n))) if the elements are  uniformly distributed if not O(n)
 * Worst-case space complexity	O(1)
 *
 * Code idea from https://github.com/TheAlgorithms
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 * @author Bakirov Insaf (https://github.com/Insafprog)
 */
object InterpolationSearch {
    /**
     * @param key   is a value what shoulb be found in the array
     * @return an index if the array contains the key unless -1
     */
    fun Array<Int>.findAlgorithm(key: Int): Int {

        // Find indexes of two corners
        var start = 0
        var end = size - 1

        // Since array is sorted, an element present
        // in array must be in range defined by corner
        while (start <= end && key >= this[start] && key <= this[end]) {
            // Probing the position with keeping
            // uniform distribution in mind.
            val pos = start + (end - start) / (this[end] - this[start]) * (key - this[start])

            // Condition of target found
            if (this[pos] == key)
                return pos

            // If key is larger, key is in upper part
            if (this[pos] < key)
                start = pos + 1
            else
                end = pos - 1
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