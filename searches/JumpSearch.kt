package searches

import kotlin.math.*

object JumpSearch: SearchAlgorithm {
    /**
     * Jump Search algorithm implements
     *
     * Code idea from https://github.com/TheAlgorithms
     * @author Bakirov Insaf (https://github.com/Insafprog)
     *
     * @param key   to be searched
     * @return index of `key` if found, otherwise <tt>-1</tt>
     */
    override fun <T : Comparable<T>> Array<T>.findAlgorithm(key: T): Int {
        val length = size //length of array
        val blockSize = sqrt(length.toDouble()).toInt() // block size to be jumped
        var limit = blockSize
        while (key > this[limit] && limit < length - 1) {
            limit = min(limit + blockSize, length - 1)
        }
        for (i in limit - blockSize..limit) {
            if (this[i] == key) { // execute linear search
                return i
            }
        }
        return -1 // not found
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val array = arrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

        array.forEachIndexed { i, _ -> assert(array.findAlgorithm(i) == i) }
        assert(array.findAlgorithm(-1) == -1)
        assert(array.findAlgorithm(11) == -1)
    }
}