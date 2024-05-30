package LongestProfit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

public class LongestProfit {

    // V1
    public static int longestProfitV1(int[] input) {
        final Integer[] current = {Integer.MIN_VALUE};
        return (int) Arrays.stream(input)
                .filter(x -> {
                    if (current[0] < x) {
                        current[0] = x;
                        return true;
                    }
                    return false;
                })
                .count();
    }

    // V2
/*    public static int longestProfit(int[] input) {
        final ArrayList<Stack<Integer>> stacks = new ArrayList<>();
        final Stack<Integer> curr = new Stack<>();
        final int[] max = {0};
        if (input == null || input.length == 0)
            return 0;
        Arrays.stream(input)
                .filter(x -> {
                    if (curr.isEmpty() || x > curr.peek()) {
                        max[0]++;
                        curr.push(x);
                        return true;
                    } else {
                        while (x < curr.peek() && !curr.isEmpty())
                            curr.pop();
                        curr.push(x);
                        return false;
                    }
                });
        return curr.size();
    }*/

    // V3
    public static int longestProfit(int[] input) {
        int[][] res = new int[input.length][input.length];
        System.out.println(Arrays.toString(input));
        for(int i=0; i<input.length-1; i++) {
            System.out.print(input[i] + "\t ");
            System.out.print("_, ".repeat(i));
            for(int j=i+1; j<input.length; j++) {
                if(input[j] < input[i])
                    res[j][i] = 0;
                else
                    res[j][i] = 1;
                System.out.print(res[j][i] + ", ");
            }
            System.out.println();
        }

        return 0;
    }

    public static int longestProfitAnswer(int[] data) {
        if(data == null || data.length == 0) {
            return 0;
        }

        int n = data.length;
        int[] dp = new int[n];
        int max = 1;

        for (int i = 0; i < n; i++) {
            // Any single element is a sequence of length 1
            dp[i] = 1;

            // We iterate through the input sequence and check if there
            // are any elements before the current element that are smaller
            // than it. If we find any, we update the dp array with the
            // maximum length of the sequence that ends at the current element.
            for (int j = 0; j < i; j++) {
                if (data[i] > data[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            max = Math.max(max, dp[i]);
        }

        return max;
    }
}