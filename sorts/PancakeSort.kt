package sorts

import sorts.SortUtils.flip
import sorts.SortUtils.less
import sorts.SortUtils.printArray

/**
 * Implementation of gnome sort
 *
 * Code idea from https://github.com/TheAlgorithms
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 * @since 2018-04-10
 * @author Bakirov Insaf (https://github.com/Insafprog)
 */
object PancakeSort: SortAlgorithm {
    override fun <T : Comparable<T>> Array<T>.sortAlgorithm(): Array<T> {
        val length = size
        for (i in 0 until length) {
            var max = this[0]
            var index = 0
            for (j in 0 until length - i) {
                if (max.less(this[j])) {
                    max = this[j]
                    index = j
                }
            }
            flip(index, length - 1 - i)
        }
        return this
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val arr = arrayOf(10, 9, 8, 7, 6, 15, 14, 7, 4, 3, 8, 6, 3, 1, 2, -2, -5, -8, -3, -1, 13, 12, 11, 5, 4, 3, 2, 1)
        println("After sorting:")
        arr.sortAlgorithm().printArray()
    }
}