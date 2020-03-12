package sorts

import java.util.*

/**
 *
 * Code idea from https://github.com/TheAlgorithms
 * Written by James Mc Dermott(theycallmemac)
 * @author Bakirov Insaf (https://github.com/Insafprog)
 *
 */

object RadixSort {
    private fun IntArray.getMax(n: Int): Int {
        var mx = this[0]
        for (i in 1 until n) {
            if (this[i] > mx)
                mx = this[i]
        }
        return mx
    }

    private fun IntArray.countSort(n: Int, exp: Int) {
        val output = IntArray(n)
        val count = IntArray(10)
        var i = 0
        Arrays.fill(count, 0)
        while (i < n) {
            count[this[i] / exp % 10]++
            i++
        }
        i = 1
        while (i < 10) {
            count[i] += count[i - 1]
            i++
        }
        i = n - 1
        while (i >= 0) {
            output[count[this[i] / exp % 10] - 1] = this[i]
            count[this[i] / exp % 10]--
            i--
        }
        i = 0
        while (i < n) {
            this[i] = output[i]
            i++
        }
    }

    private fun IntArray.radixsort(): IntArray {
        val n = size
        val m = getMax(n)
        var exp = 1
        while (m / exp > 0) {
            countSort(n, exp)
            exp *= 10
        }
        return this
    }

    fun IntArray.printArray() {
        forEach { print("$it ") }
        println()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val arr = intArrayOf(170, 45, 75, 90, 802, 24, 2, 66)
        arr.radixsort().printArray()
    }
}
