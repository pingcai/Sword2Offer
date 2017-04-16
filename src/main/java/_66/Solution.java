package _66;

/**
 * Created by pingcai on 2017/4/16.
 */
public class Solution {
    int pathLen = 0;

    //StringBuilder path = new StringBuilder();
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || str == null || matrix.length < str.length || matrix.length != rows * cols) {
            return false;
        }
        boolean[] visited = new boolean[matrix.length];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (v(matrix, rows, cols, row, col, str, pathLen, visited)) {
                    //System.out.println(path.toString()); //可以通过这个记住走过的路径
                    return true;
                }
            }
        }
        return false;
    }

    private boolean v(char[] matrix, int rows, int cols, int row, int col, char[] str, int pathLen, boolean[] visited) {
        if (pathLen == str.length) {
            return true;
        }
        boolean hasPath = false;
        int i = row * cols + col; //当前位置
        if (row >= 0 && row < rows && col >= 0 && col < cols && matrix[i] == str[pathLen] && !visited[i]) {
            //path.append(i);
            pathLen++;
            visited[i] = true;
            hasPath = v(matrix, rows, cols, row - 1, col, str, pathLen, visited)
                    || v(matrix, rows, cols, row + 1, col, str, pathLen, visited)
                    || v(matrix, rows, cols, row, col - 1, str, pathLen, visited)
                    || v(matrix, rows, cols, row, col + 1, str, pathLen, visited);

            if (!hasPath) {
                //path.deleteCharAt(path.length()-1);
                --pathLen;
                visited[i] = false;
            }
        }
        return hasPath;
    }

}

class Test {
    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e'};
        System.out.println(new Solution().hasPath(chars, 3, 4, "asadfb".toCharArray()));

    }
}
