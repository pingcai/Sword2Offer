package common.dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by pingcai on 2017/3/31.
 */
public class _01PackageProblem {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new FileInputStream("D:\\IdeaProject\\Sword2Offer\\src\\main\\test\\data.txt"));

        int n = sc.nextInt();

        int[] w = new int[n];
        int[] v = new int[n];

        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            v[i] = sc.nextInt();
        }
        int m = sc.nextInt(); // 目标重量

        System.out.println(dnp(v, w, w.length, m));

    }

    private static int dnp(int[] v, int[] w, int n, int W) {

        int[][] c = new int[W][W];

        for (int i = 0; i < n; i++) {
            c[0][i] = 0;
        }

        for (int i = 1; i < n; i++) {
            c[i][0] = 0;
            for (int j = 1; j < W; j++) {
                if(w[i] <= j){ // j为遍历的w
                    if(v[i] + c[i-1][j-w[i]] > c[i-1][j]){
                        c[i][j] = v[i] + c[i-1][j-w[i]];
                    }else{
                        c[i][j] = c[i-1][j];
                    }
                }else{
                    c[i][j] = c[i-1][j];
                }
            }

        }
        for (int i = 0; i < W; i++) {
            System.out.println(Arrays.toString(c[i]));
        }
        return c[n][W-1];
    }

    public static int max(int max, int i) {
        if (max < i) {
            return i;
        }
        return max;
    }


}
