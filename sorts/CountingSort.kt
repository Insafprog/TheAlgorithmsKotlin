package sorts

import sorts.SortUtils.printArray
import java.util.*
import java.util.stream.Collectors
import java.util.stream.IntStream

/**
 * Code idea from https://github.com/TheAlgorithms
 * @author Youssef Ali (https://github.com/youssefAli11997)
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 * @author Bakirov Insaf (https://github.com/Insafprog)
 */
object CountingSort : SortAlgorithm {
    override fun <T : Comparable<T>> Array<T>.sortAlgorithm(): Array<T> {
        return arrayOf<Any>(toList().sortAlgorithm()) as Array<T>
    }

    /**
     * This method implements the Generic Counting Sort
     *
     * Sorts the list in increasing order
     * The method uses list elements as keys in the frequency map
     */
    override fun <T : Comparable<T>> List<T>.sortAlgorithm(): List<T> {
        val frequency = sortedMapOf<T, Int>()
        // The final output array
        val sortedArray = mutableListOf<T>()

        // Counting the frequency of @param array elements
        forEach{ frequency[it] = frequency.getOrDefault(it, 0) + 1 }

        // Filling the sortedArray
        for ((key, value) in frequency) {
            for (j in 0 until value) {
                sortedArray.add(key)
            }
        }
        return sortedArray
    }


    // Driver Program
    @JvmStatic
    fun main(args: Array<String>) {
        // Integer Input
        val unsortedInts =  listOf(4, 23, 6, 78, 1, 54, 23, 1, 9, 231, 9, 12)

        println("Before Sorting:")
        unsortedInts.printArray()

        // Output => 1 1 4 6 9 9 12 23 23 54 78 231
        println("After Sorting:")
        unsortedInts.sortAlgorithm().printArray()

        println("\n------------------------------\n")

        // String Input
        val unsortedStrings = listOf("c", "a", "e", "b", "d", "a", "f", "g", "c")
        println("Before Sorting:")
        unsortedStrings.printArray()

        //Output => a a b c c d e f g
        println("After Sorting:")
        unsortedStrings.sortAlgorithm().printArray()
    }
}