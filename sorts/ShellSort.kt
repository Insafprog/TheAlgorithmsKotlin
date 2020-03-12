package sorts

import sorts.SortUtils.less
import sorts.SortUtils.printArray

object ShellSort: SortAlgorithm {
    /**
     * Code idea from https://github.com/TheAlgorithms
     * This method implements Generic Shell Sort.
     * @author Bakirov Insaf (https://github.com/Insafprog)
     */
    override fun <T : Comparable<T>> Array<T>.sortAlgorithm(): Array<T> {
        val length = size
        var gap = 1

        // Calculate gap for optimization purpose
        while (gap < length / 3) {
            gap = 3 * gap + 1
        }
        while (gap > 0) {
            for (i in gap until length) {
                var j = i
                while (j >= gap && this[j].less(this[j - gap])) {
                    this[j] = this[j - gap]
                    j -= gap
                }
                this[j] = this[i]
            }
            gap /= 3
        }
        return this
    }

    /* Driver Code */
    @JvmStatic
    fun main(args: Array<String>) {
        val toSort = arrayOf(4, 23, 6, 78, 1, 54, 231, 9, 12)

        toSort.sortAlgorithm().printArray()
    }
}