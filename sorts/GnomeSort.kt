package sorts

import sorts.SortUtils.less
import sorts.SortUtils.printArray
import sorts.SortUtils.swap

/**
 * Implementation of gnome sort
 *
 * Code idea from https://github.com/TheAlgorithms
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 * @author Bakirov Insaf (https://github.com/Insafprog)
 */
object GnomeSort : SortAlgorithm {
    override fun <T : Comparable<T>> Array<T>.sortAlgorithm(): Array<T> {
        var i = 1
        var j = 2
        while (i < size) {
            if (this[i - 1].less(this[i])) i = j++ else {
                swap(i - 1, i)
                if (--i == 0) {
                    i = j++
                }
            }
        }
        return this
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val integers = arrayOf(4, 23, 6, 78, 1, 26, 11, 23, 0, -6, 3, 54, 231, 9, 12)
        val strings = arrayOf("c", "a", "e", "b", "d", "dd", "da", "zz", "AA", "aa", "aB", "Hb", "Z")
        println("After sort : ")
        integers.sortAlgorithm().printArray()
        strings.sortAlgorithm().printArray()
    }
}