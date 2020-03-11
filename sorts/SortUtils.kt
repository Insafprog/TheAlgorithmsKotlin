package sorts

/**
 * The class contains util methods
 *
 * Code idea from https://github.com/TheAlgorithms
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 * @author Bakirov Insaf (https://github.com/Insafprog)
 */

object SortUtils {

    /**
     * Helper method for swapping places in array
     *
     * @param idx   index of the first element
     * @param idy   index of the second element
     */

    fun <T> Array<T>.swap(idx: Int, idy: Int): Boolean {
        val swap = this[idx]
        this[idx] = this[idy]
        this[idy] = swap
        return true
    }

    /**
     * This method checks if first element is less then the other element
     *
     * @param second second element
     * @return true if the first element is less then the second element
     */

    fun <T: Comparable<T>> T.less(second: T) = this < second

    /**
     * Just print list
     *
     */

    fun<T> List<T>.printArray() {
        map { it.toString() }
            .map { "$it " }
            .forEach { print(it) }

        println()
    }

    /**
     * Prints an array
     *
     */

    fun <T> Array<T>.printArray() = println(contentToString())

    /**
     * Swaps all position from {@param left} to @{@param right} for {@param array}
     *
     * @param left  is a left flip border of the array
     * @param right is a right flip border of the array
     */

    fun <T: Comparable<T>> Array<T>.flip(left: Int, right: Int) {
        var idx = left
        var idy = right
        while (idx <= idy) {
            swap(idx++, idy--)
        }
    }
}