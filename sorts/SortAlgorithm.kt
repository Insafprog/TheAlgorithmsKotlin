package sorts

/**
 * The common interface of most sorting algorithms
 *
 * Code idea from https://github.com/TheAlgorithms
 */

interface SortAlgorithm {

    /**
     * Main method arrays sorting algorithms
     *
     * @return a sorted array
     * @author Podshivalov Nikita (https://github.com/nikitap492)
     * @author Bakirov Insaf (https://github.com/Insafprog)
     */

    fun <T: Comparable<T>> Array<T>.sortAlgorithm(): Array<T>

    /**
     * Auxiliary method for algorithms what wanted to work with lists from JCF
     *
     * @return a sorted list
     */

    @Suppress("UNCHECKED_CAST")
    fun <T: Comparable<T>> List<T>.sortAlgorithm(): List<T> {
        val array = arrayOf<Any>(this) as Array<T>
        return array.sortAlgorithm().toList()
    }
}