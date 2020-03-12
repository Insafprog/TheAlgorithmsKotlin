package searches

/**
 * Binary search is one of the most popular algorithms
 * This class represents iterative version  [BinarySearch]
 * Iterative binary search is likely to have lower constant factors because it doesn't involve the overhead of manipulating the call stack.
 * But in java the recursive version can be optimized by the compiler to this version.
 *
 *
 * Worst-case performance	O(log n)
 * Best-case performance	O(1)
 * Average performance	O(log n)
 * Worst-case space complexity	O(1)
 *
 * Code idea from https://github.com/TheAlgorithms
 * @author Gabriele La Greca : https://github.com/thegabriele97
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 * @author Bakirov Insaf (https://github.com/Insafprog)
 *
 * @see SearchAlgorithm
 *
 * @see BinarySearch
 */
object IterativeBinarySearch: SearchAlgorithm {
    /**
     * This method implements an iterative version of binary search algorithm
     *
     * @param key   the key to search in array
     * @return the index of key in the array or -1 if not found
     */
    override fun <T : Comparable<T>> Array<T>.findAlgorithm(key: T): Int {
        var l = 0
        var r = size - 1
        var k: Int
        var cmp: Int
        while (l <= r) {
            k = (l + r) / 2
            cmp = key.compareTo(this[k])
            when {
                cmp == 0 -> return k
                cmp < 0 -> r = --k
                else -> l = ++k
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