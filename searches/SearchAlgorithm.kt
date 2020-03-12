package searches

/**
 * The common interface of most searching algorithms
 *
 * Code idea from https://github.com/TheAlgorithms
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 * @author Bakirov Insaf (https://github.com/Insafprog)
 */
interface SearchAlgorithm {
    /**
     * @param key   is an element which should be found
     * @param <T>   Comparable type
     * @return first found index of the element
    </T> */
    fun <T : Comparable<T>> Array<T>.findAlgorithm(key: T): Int
}