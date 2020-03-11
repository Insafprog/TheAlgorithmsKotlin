package sorts

import sorts.SortUtils.less
import sorts.SortUtils.printArray
import sorts.SortUtils.swap
import kotlin.random.Random


/**
 * BogoSort
 *
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 * @author Bakirov Insaf (https://github.com/Insafprog)
 * Code idea from https://github.com/TheAlgorithms
 */

object BogoSort: SortAlgorithm {

    private val random = Random

    private fun <T : Comparable<T>> Array<T>.isSorted(): Boolean {
        for (i in 0 until size - 1) {
            if (this[i + 1].less(this[i])) return false
        }
        return true
    }

    // Randomly shuffles the array
    private fun <T> Array<T>.nextPermutation() {
        val length = size

        for (i in indices) {
            val randomIndex = i + random.nextInt(length - i)
            swap(randomIndex, i)
        }
    }


    override fun <T : Comparable<T>> Array<T>.sortAlgorithm(): Array<T> {
        while (!isSorted()) {
            nextPermutation()
        }
        return this
    }

    // Driver Program

    @JvmStatic
    fun main(args: Array<String>) {
        // Integer Input
        val integers = arrayOf(4, 23, 6, 78, 1, 54, 231, 9, 12)

        // print a sorted array
        integers.sortAlgorithm().printArray()

        // String Input
        val strings = arrayOf("c", "a", "e", "b", "d")

        strings.sortAlgorithm().printArray()
    }
}