package _22;

/**
 * Created by pingcai on 17-3-20.
 */

import java.util.Scanner;
import java.util.Stack;

public class StackPushPopOrder {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();

        int[] arr1 = new int[len];
        int[] arr2 = new int[len];

        String line1 = sc.next();
        String line2 = sc.next();

        String[] n1 = line1.split(",");
        String[] n2 = line2.split(",");

        if (arr1 == null || arr2 == null || arr1.length != arr2.length) {
            System.out.println("false");
            return;
        }

        for (int i = 0; i < n1.length; i++) {
            try {
                arr1[i] = Integer.parseInt(n1[i]);
                arr2[i] = Integer.parseInt(n2[i]);
            } catch (Exception e) {
                System.out.println("false");
                System.exit(0);
            }
        }
        System.out.println(new StackPushPopOrder().IsPopOrder(arr1, arr2));
    }

    public boolean IsPopOrder(int[] arr1, int[] arr2) {

        boolean flag = false;
        Stack<Integer> stack = new Stack<>();
        int len = arr1.length;
        int index1 = 0;
        int index2 = 0;

        //stack.push(arr1[index1++]);

        while (index2 < len) {
            while ((stack.empty() || stack.peek() != arr2[index2])) {
                if (index1 == len) {
                    break;
                }
                stack.push(arr1[index1++]);
            }
            if (stack.peek() != arr2[index2]) {
                break;
            }
            stack.pop();
            index2++;
        }
        if (stack.empty() && index2 == len) {
            flag = true;
        }
        return flag;
    }
}