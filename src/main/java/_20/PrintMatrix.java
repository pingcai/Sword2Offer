package _20;

/**
 * Created by pingcai on 17-3-19.
 * <p>
 * 转圈打印二维数组
 */
public class PrintMatrix {

    public static void main(String[] args) {
        PrintMatrix m = new PrintMatrix();
        int[][] arr = m.scanf();
        System.out.println(m.printMatrix(arr));;
    }

    public java.util.ArrayList<Integer> printMatrix(int[][] arr) {
        if (arr == null || arr.length < 0) {
            return null;
        }
        java.util.ArrayList<Integer> list = new java.util.ArrayList<>();
        int start = 0;
        int rows = arr.length;
        int columns = arr[0].length;

        while (start * 2 < rows && start * 2 < columns) {
            r(arr, rows, columns, start++, list);
        }
        return list;
    }

    public void r(int[][] arr, int rows, int columns, int start, java.util.ArrayList<Integer> list) {
        int endX = columns - start - 1; // X轴 最末尾
        int endY = rows - start - 1; // 是下标
        //第一行
        for (int j = start; j <= endX; j++) {
            list.add(arr[start][j]);
            //System.out.println(arr[start][j] + "\t");
        }
        //接下来的竖下的一行
        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                list.add(arr[i][endX]);
                //System.out.println(arr[i][endX]);
            }
        }
        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; i--) {
                list.add(arr[endY][i]);
                //System.out.println(arr[endY][i]);
            }
        }
        //从下到上
        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i >= start + 1; i--) {
                list.add(arr[i][start]);
                //System.out.println(arr[i][start]);
            }
        }
    }

    private int[][] scanf() {

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
