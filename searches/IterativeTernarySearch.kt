package searches

/**
 * A iterative version of a ternary search algorithm
 * This is better way to implement the ternary search, because a recursive version adds some overhead to a stack.
 * But in kotlin the compile can transform the recursive version to iterative implicitly,
 * so there are no much differences between these two algorithms
 * <p>
 * Worst-case performance	Θ(log3(N))
 * Best-case performance	O(1)
 * Average performance	Θ(log3(N))
 * Worst-case space complexity	O(1)
 *
 * Code idea from https://github.com/TheAlgorithms
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 * @author Bakirov Insaf (https://github.com/Insafprog)
 * @see SearchAlgorithm
 * @see TernarySearch
 * @since 2020-03-12
 */

object IterativeTernarySearch: SearchAlgorithm {
    override fun <T: Comparable<T>> Array<T>.findAlgorithm(key: T): Int {
        var left = 0
        var right = size - 1
        while (right > left) {
            if (this[left] == key)
                return left
            if (this[right] == key)
                return right
            val leftThird = left + (right - left) / 3 + 1
            val rightThird = right - (right - left) / 3 - 1
            if (this[leftThird] <= key) {
                left = leftThird
            }
            else {
                right = rightThird
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