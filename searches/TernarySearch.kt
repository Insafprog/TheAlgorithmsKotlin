package searches

/**
 * A ternary search algorithm is a technique in computer science for finding the minimum or maximum of a unimodal function
 * The algorithm determines either that the minimum or maximum cannot be in the first third of the domain
 * or that it cannot be in the last third of the domain, then repeats on the remaining third.
 *
 *
 * Worst-case performance	Θ(log3(N))
 * Best-case performance	O(1)
 * Average performance	Θ(log3(N))
 * Worst-case space complexity	O(1)
 *
 * Code idea from https://github.com/TheAlgorithms
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 * @author Bakirov Insaf (https://github.com/Insafprog)
 * @see SearchAlgorithm
 *
 * @see IterativeBinarySearch
 */
object TernarySearch: SearchAlgorithm {
    /**
     * @param key The value that we want to search for.
     * @return The index of the element if found.
     * Else returns -1.
     */
    override fun <T : Comparable<T>> Array<T>.findAlgorithm(key: T): Int {
        return ternarySearch(key, 0, size - 1)
    }

    /**
     * @param key   The value that we want to search for.
     * @param start The starting index from which we will start Searching.
     * @param end   The ending index till which we will Search.
     * @return Returns the index of the Element if found.
     * Else returns -1.
     */
    private fun <T : Comparable<T>> Array<T>.ternarySearch(key: T, start: Int, end: Int): Int {
        if (start > end) {
            return -1
        }
        /* First boundary: add 1/3 of length to start */
        var mid1 = start + (end - start) / 3
        /* Second boundary: add 2/3 of length to start */
        var mid2 = start + 2 * (end - start) / 3
        return when {
            key == this[mid1] -> mid1
            key == this[mid2] -> mid2
            key < this[mid1] -> ternarySearch(key, start, --mid1)
            key > this[mid2] -> ternarySearch(key, ++mid2, end)
            else -> ternarySearch(key, mid1, mid2)
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