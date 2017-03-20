import com.sun.corba.se.impl.orbutil.ObjectStreamClassUtil_1_3;
import sun.awt.motif.X11CNS11643;

/**
 * Created by pingcai on 17-3-19.
 * <p>
 * 转圈打印二维数组
 */
public class _20_PrintMatrix {

    public static void main(String[] args) {

        int[][] arr = scanf();

        printMatrix(arr);
    }

    private static void printMatrix(int[][] arr) {

        if (arr == null || arr.length < 0) {
            return;
        }

        int start = 0;

        int rows = arr.length;
        int columns = arr[0].length;

        while (start * 2 < rows && start * 2 < columns) {
            r(arr, rows, columns, start++);
        }

    }

    private static void r(int[][] arr, int rows, int columns, int start) {

        int endX = columns - start - 1; // X轴 最末尾
        int endY = rows - start - 1; // 是下标

        //第一行
        for (int j = 0; j <= endX; j++) {
            System.out.println(arr[start][j] + "\t");
        }

        //接下来的竖下的一行
        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                System.out.println(arr[i][endX]);
            }
        }

        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; i--) {
                System.out.println(arr[endY][i]);
            }
        }

        //从下到上
        if (start < endX && start < endY -1) {
            for (int i = endY - 1; i >= start + 1; i--) {
                System.out.println(arr[i][start]);
            }
        }


    }


    private static int[][] scanf() {

        java.util.Scanner sc = new java.util.Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();

        int[][] arr = new int[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        sc.close();
        return arr;
    }

}
