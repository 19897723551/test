package org.example;
import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] nums = new int[n];
        int i = 0;
        while (in.hasNextInt()) {
            nums[i++] = in.nextInt();
        }
        int[] maxGongNums = new int[n - 1];
        for (int j = 0; j < nums.length - 1; j++) {
            maxGongNums[j] = maxGong(nums[j], nums[j + 1]);
            //System.out.print(maxGongNums[j]);
        }
        int s = -1;
        int temp = 0;
        int[][] a = new int[n][n];
        for (int l = 0; l < nums.length - 1; l++) {
            temp = 0;
            int lsum = 0;
            int pr = 0;
            for (int r = 0; r < nums.length - 1; r++) {
                temp += maxGongNums[r];
                lsum += nums[r];
                if (l != r && lsum+nums[r+1] <= k) {
                    s = Math.max(s, temp);
                } else {
                    continue;
                }
                pr = r;
            }
            a[l][pr] = s;
        }
        System.out.print(s);
    }

    // public static boolean checkSum(int k, int l, int r, int[] nums) {
    //     int sum = 0;
    //     for (int i = l; i <= r; i++) {
    //         sum += nums[i];
    //     }
    //     //System.out.println("sum"+sum+"l"+l+"r"+r);
    //     if (sum <= k) {
    //         return true;
    //     }
    //     return false;
    // }

    public static int maxGong(int a, int b) {
        if (a % b == 0) return b;
        if (b % a == 0) return a;
        int maxNum = 1;
        for (int i = 1; i < Math.min(a, b); i++) {
            if (a % i == 0 && b % i == 0) {
                maxNum = Math.max(maxNum, i);
            }
        }
        return maxNum+1;
    }
}






