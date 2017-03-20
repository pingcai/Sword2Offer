/**
 * Created by pingcai on 2017/2/19.
 */
public class _03_FindInPartiallySortedMatrix {
    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {6, 7, 12, 13},
                {8, 9, 14, 17},
        };
        System.out.println(downLeftFind(array, 7));
        System.out.println(downLeftFind(array, 1));
        System.out.println(downLeftFind(array, 8));
        System.out.println(downLeftFind(array, 12));
        System.out.println(downLeftFind(array, 19));
    }


    /**
     * 在一个二维数组中找出目标的下标
     * 二维数组往下和往右递增
     * 如：
     * 1 5 9
     * 2 8 27
     * 7 12 56
     * <p>
     * 思路：
     * 从右上角或左下角计算，target和顶点比较，>target删除列 <target 删除行
     *
     * @param array
     * @param target
     */
    private static boolean upRightFind(int[][] array, int target) {

        boolean flag = false;
        int len = array.length;
        int row = 0;
        int cols = len - 1;

        if (null == array || len == 0) {
            return false;
        }

        while (row < len && cols >= 0) {

            int temp = array[row][cols];

            if (temp > target) {
                cols--;
            } else if (temp < target) {
                row++;
            } else {
                flag = true;
                break;
            }
        }
        return flag;
    }


    private static boolean downLeftFind(int[][] array, int target) {

        boolean flag = false;
        int len = array.length;
        int row = len - 1;
        int col = 0;

        if (null == array || len == 0) {
            return false;
        }

        while (row >= 0 && col < len) {

            int temp = array[row][col];

            if (temp > target) {
                row--;
            } else if (temp < target) {

                col++;
            } else {
                flag = true;
                break;
            }
        }
        return flag;
    }

}
