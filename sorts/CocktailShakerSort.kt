package sorts

import sorts.SortUtils.less
import sorts.SortUtils.printArray
import sorts.SortUtils.swap

/**
 * CocktailShakerSort
 *
 * @author Mateus Bizzo (https://github.com/MattBizzo)
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 * @author Bakirov Insaf (https://github.com/Insafprog)
 * Code idea from https://github.com/TheAlgorithms
 */
object CocktailShakerSort : SortAlgorithm {
    /**
     * This method implements the Generic Cocktail Shaker Sort
     *
     * Sorts the array in increasing order
     */
    override fun <T : Comparable<T>> Array<T>.sortAlgorithm(): Array<T> {
        val length = size
        var left = 0
        var right = length - 1
        var swappedLeft: Int
        var swappedRight: Int
        while (left < right) {
            // front
            swappedRight = 0
            for (i in left until right) {
                if (this[i + 1].less(this[i])) {
                    swap(i, i + 1)
                    swappedRight = i
                }
            }
            // back
            right = swappedRight
            swappedLeft = length - 1
            for (j in right downTo left + 1) {
                if (this[j].less(this[j - 1])) {
                    swap(j - 1, j)
                    swappedLeft = j
                }
            }
            left = swappedLeft
        }
        return this
    }

    // Driver Program
    @JvmStatic
    fun main(args: Array<String>) {
        // Integer Input
        val integers = arrayOf(4, 23, 6, 78, 1, 54, 231, 9, 12)

        // Output => 1 4 6 9 12 23 54 78 231
        integers.sortAlgorithm().printArray()

        // String Input
        val strings = arrayOf("c", "a", "e", "b", "d")
        strings.sortAlgorithm().printArray()
    }
}