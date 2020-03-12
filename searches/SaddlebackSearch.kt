package searches

import java.util.*

/**
 * Program to perform Saddleback Search
 * Given a sorted 2D array(elements are sorted across every row and column, assuming ascending order)
 * of size n*m we can search a given element in O(n+m)
 *
 *
 * we start from bottom left corner
 * if the current element is greater than the given element then we move up
 * else we move right
 * Sample Input:
 * 5 5 ->Dimensions
 * -10 -5 -3 4 9
 * -6 -2 0 5 10
 * -4 -1 1 6 12
 * 2 3 7 8 13
 * 100 120 130 140 150
 * 140 ->element to be searched
 * output: 4 3 // first value is row, second one is column
 *
 * Code idea from https://github.com/TheAlgorithms
 * @author Nishita Aggarwal
 * @author Bakirov Insaf (https://github.com/Insafprog)
 */
object SaddlebackSearch {
    /**
     * This method performs Saddleback Search
     *
     * @param row the current row.
     * @param col the current column.
     * @param key the element that we want to search for.
     * @return The index(row and column) of the element if found.
     * Else returns -1 -1.
     */
    private fun Array<Array<Int>>.findAlgorithm(row: Int, col: Int, key: Int): Array<Int> {

        //array to store the answer row and column
        val ans = arrayOf(-1, -1)
        if (row < 0 || col >= this[row].size) {
            return ans
        }
        if (this[row][col] == key) {
            ans[0] = row
            ans[1] = col
            return ans
        } else if (this[row][col] > key) {
            return findAlgorithm(row - 1, col, key)
        }
        //else we move right
        return findAlgorithm(row, col + 1, key)
    }

    /**
     * Main method
     *
     * @param args Command line arguments
     */
    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        val arr: Array<Array<Int>>
        var i = 0
        var j: Int
        val rows = sc.nextInt()
        val col = sc.nextInt()
        arr = Array(rows) { Array(col) {0} }
        while (i < rows) {
            j = 0
            while (j < col) {
                arr[i][j] = sc.nextInt()
                j++
            }
            i++
        }
        val ele = sc.nextInt()
        //we start from bottom left corner
        val ans = arr.findAlgorithm(rows - 1, 0, ele)
        println("${ans[0].toString()} ${ans[1]}")
        sc.close()
    }
}