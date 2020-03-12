package sorts

import sorts.SortUtils.less
import sorts.SortUtils.printArray
import sorts.SortUtils.swap

/**
 * Heap Sort Algorithm
 * Implements MinHeap
 *
 * Code idea from https://github.com/TheAlgorithms
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 * @author Bakirov Insaf (https://github.com/Insafprog)
 */
object HeapSort : SortAlgorithm {

    /**
    * Constructor
    *
    * @param heap array of unordered integers
    *
    * Array to store heap
    *
    * Heapifies subtree from top as root to last as last child
    *
    * @param rootIndex index of root
    * @param lastChild index of last child
    */

    private class Heap<T: Comparable<T>>(private val heap: Array<T>) {

        private fun heapSubtree(rootIndex: Int, lastChild: Int) {
            val leftIndex = rootIndex * 2 + 1
            val rightIndex = rootIndex * 2 + 2
            val root = heap[rootIndex]
            if (rightIndex <= lastChild) { // if has right and left children
                val left = heap[leftIndex]
                val right = heap[rightIndex]
                if (left.less(right) && left.less(root)) {
                    heap.swap(leftIndex, rootIndex)
                    heapSubtree(leftIndex, lastChild)
                } else if (right.less(root)) {
                    heap.swap(rightIndex, rootIndex)
                    heapSubtree(rightIndex, lastChild)
                }
            } else if (leftIndex <= lastChild) { // if no right child, but has left child
                val left = heap[leftIndex]
                if (left.less(root)) {
                    heap.swap(leftIndex, rootIndex)
                    heapSubtree(leftIndex, lastChild)
                }
            }
        }

        /**
         * Makes heap with root as root
         *
         * @param root index of root of heap
         */
        fun makeMinHeap(root: Int) {
            val leftIndex = root * 2 + 1
            val rightIndex = root * 2 + 2
            val hasLeftChild = leftIndex < heap.size
            val hasRightChild = rightIndex < heap.size
            if (hasRightChild) { //if has left and right
                makeMinHeap(leftIndex)
                makeMinHeap(rightIndex)
                heapSubtree(root, heap.size - 1)
            } else if (hasLeftChild) {
                heapSubtree(root, heap.size - 1)
            }
        }

        /**
         * Gets the root of heap
         *
         * @return root of heap
         */
        fun getRoot(size: Int): T {
            heap.swap(0, size)
            heapSubtree(0, size - 1)
            return heap[size] // return old root
        }

    }

    @Suppress("UNCHECKED_CAST")
    override fun <T: Comparable<T>> Array<T>.sortAlgorithm(): Array<T> {
        var length = size
        val heap = Heap(this)
        heap.makeMinHeap(0) // make min heap using index 0 as root.
        val sorted = this.clone()
        var index = 0
        while (length > 0) {
            val min = heap.getRoot(--length)
            sorted[index] = min
            index++
        }

        return sorted
    }

    /**
     * Main method
     *
     * @param args the command line arguments
     */
    @JvmStatic
    fun main(args: Array<String>) {
        val heap = arrayOf(4, 23, 6, 78, 1, 54, 231, 9, 12)
        heap.sortAlgorithm().printArray()
    }
}