package sorts

import sorts.SortUtils.less
import sorts.SortUtils.printArray

/**
 * Code idea from https://github.com/TheAlgorithms
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 * @author Bakirov Insaf (https://github.com/Insafprog)
 */
object CycleSort : SortAlgorithm {
    override fun <T : Comparable<T>>  Array<T>.sortAlgorithm(): Array<T> {
        val length = size

        // traverse array elements
        for (j in 0..length - 2) {
            // initialize item as starting point
            var item = this[j]

            // Find position where we put the item.
            var pos = j
            for (i in j + 1 until length) if (this[i].less(item)) pos++

            // If item is already in correct position
            if (pos == j) continue

            // ignore all duplicate elements
            while (item.compareTo(this[pos]) == 0) pos += 1

            // put the item to it's right position
            if (pos != j) {
                item = replace(pos, item)
            }

            // Rotate rest of the cycle
            while (pos != j) {
                pos = j

                // Find position where we put the element
                for (i in j + 1 until length) if (this[i].less(item)) {
                    pos += 1
                }


                // ignore all duplicate elements
                while (item.compareTo(this[pos]) == 0) pos += 1

                // put the item to it's right position
                if (item != this[pos]) {
                    item = replace(pos, item)
                }
            }
        }
        return this
    }

    private fun <T : Comparable<T>> Array<T>.replace(pos: Int, item: T): T {
        val itm = this[pos]
        this[pos] = item
        return itm
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val arr = arrayOf(4, 23, 6, 78, 1, 26, 11, 23, 0, -6, 3, 54, 231, 9, 12)
        arr.sortAlgorithm()
        println("After sort : ")
        arr.printArray()
    }
}