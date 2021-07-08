package com.javarush.task.task20.task2025;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.String.*;

/* 
Алгоритмы-числа
*/

public class Solution {
    private static long pows[][] = new long[11][20];

    static {
        for (int i = 0; i < 11; i++) {
            pows[i][0] = 1;
            //System.out.print(pows[i][0] + " ");
            for (int j = 1; j < 20; j++) {
                pows[i][j] = pows[i][j-1] * i;
                //System.out.print(pows[i][j] + " ");
            }
            //System.out.println("");
        }
    }

    public static long[] getNumbers(long N) {
        long[] result = null;
        ArrayList<Long> list = new ArrayList<Long>();

        for (int i = 0; i < nums.length; i++) {
            nums[i] = 0;
        }
        long n = N;
        for (int i = 0; i < nums.length; i++) {
            maxNums[i] = (int) (n % 10);
            n = n / 10;
            if (n != 0L)
                maxHighestDigitNo = i;
        }
        //printMaxNums();
        //System.out.println("maxHighestDigitNo = " + maxHighestDigitNo);
        while (true) {
            incDigit(0);
            propagate();
            if (!lessThanMax()) break;
            //printNums();

            long armstrong = estimateArmstrong();
            if ((armstrong > 0) && (armstrong < N)) {
                //printNums();
                //System.out.println("highestDigitNo = " + highestDigitNo);
                list.add(armstrong);
            }
        }
        //System.out.println("Last num:");
        //printNums();

        Long res[] = list.toArray(new Long[0]);
        Arrays.sort(res);
        result = new long[res.length];
        for (int i = 0; i < res.length; i++) {
            result[i] = res[i];
        }

        return result;
    }

    public static long[] getNumbersOld(long N) {
        long[] result = null;
        ArrayList<Long> list = new ArrayList<Long>();

        /*
        if (N > 0) {
            list.add(0L);
        }
        */

        for (int i = 1; i < 20; i++) {
            list.addAll(getArmstrongNumbers(i, N));
        }

        Long res[] = list.toArray(new Long[0]);
        Arrays.sort(res);
        result = new long[res.length];
        for (int i = 0; i < res.length; i++) {
            result[i] = res[i];
        }

        return result;
    }

    private static List<Long> getArmstrongNumbers(int deg10, long max) {
        List<Long> result = new ArrayList<Long>();
        long cnt = 0;


        long maxValue ;
        if (deg10 >= 19)
            maxValue = Long.MAX_VALUE;
        else
            maxValue = pow(10, deg10);

        if (maxValue < 0 || maxValue > max) {
            maxValue = max;
        }

        long sumMinValue = pow(10, deg10-1);

        long cur;
        long next;
        for (long num = 1; num < maxValue && num > 0; num++) {
            if ((num % 10) == 0) {
                for (int j = deg10; j > 1; j--) {
                    //cur = getDigit(num, j);
                    cur = num / pow(10, j-1) % 10;
                    next = getDigit(num, j-1);
                    //System.out.println("  " + cur + " " + next);
                    if (next < cur) {
                        //System.out.println(" +" + pow(10,j-2) * (cur-next));
                        num = num + pow(10,j-2) * (cur-next);
                    }
                }
            }

            if (num >= 0) {
                long sum = getSum(num, deg10);
                if (sum >= sumMinValue && sum <= maxValue) {
                    if (getDigitSum(num) == getDigitSum(sum)) {
                        String s1 = String.format("%"+deg10+"s", valueOf(num)).replace(" ", "0")
                                .chars()
                                .sorted()
                                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                                .toString();
                        String s2 = valueOf(sum)
                                .chars()
                                .sorted()
                                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                                .toString();
                        if (s1.equals(s2)) {
                            result.add(sum);
                        }
                    }
                }
                cnt++;
            }

        }

        /*
        System.out.print(deg10 + " (cnt="+cnt+"): ");
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i)+",");
        }
        System.out.println("");
        */
        return result;
    }

    private static void getArmstrongNumbers1(long max) {
        List<Long> result = new ArrayList<Long>();
        long cnt = 0;

        for (int nDigit = 0; nDigit < nums.length; nDigit++) {
            while (nums[nDigit] != 10) {
                // call
                nums[nDigit]++;
                // propagate(nDigit);
            }
            if (nDigit < nums.length - 1) {
                nums[nDigit+1]++;
                // propagate(nDigit+1)
            }
        }

        int i = 0;
        while (true) {
            nums[i]++;
            if (nums[i] == 10) {
                nums[i] = 0;
            }
        }
    }

    private static long getSum(long num, int deg10) {
        long sum = 0;
        for (int j = 1; j <= deg10; j++) {
            sum += pow(getDigit(num, j), deg10);
        }
        return sum;
    }

    private static int getDigitSum(long num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }

    private static long pow(long n, int m) {
        long num = 1;
        return pows[(int) n][m];

        /*
        if (m<0 || n<0) System.out.println("19: " + n);
        for (int i = 0; i < m; i++) {
            num *= n;
        }
        if (num != pows[(int) n][m])
            System.out.println("aaa");
        return num;
         */

    }

    private static long getDigit(long n, int pos) {
        //n = n / pow(10, pos-1);
        //return n % 10;
        return n / pow(10, pos-1) % 10;
    }



    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        //System.out.println(Arrays.toString(getNumbers(0)));
        //System.out.println(Arrays.toString(getNumbers(1_000_000L)));
        //System.out.println(Arrays.toString(getNumbers(Long.MAX_VALUE)));
        System.out.println(Arrays.toString(getNumbers(Long.MAX_VALUE)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024));
        System.out.println("time = " + (b - a) / 1000);
    }

////////////////////////////////////////////////////////////////

    private static int[] nums = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    private static int highestDigitNo = 0;

    private static int[] maxNums = {0,7,0,8,5,7,7,4,5,8,6,3,0,2,7,3,3,2,2,9};
    private static int maxHighestDigitNo = 0;

    private static void incDigit(int n) {
        nums[n]++;
        if (nums[n] == 10) {
            nums[n] = 0;
            incDigit(n+1);
        }
    }

    private static void propagate() {
        highestDigitNo = 0;
        for (int i = nums.length-1; i >=1; i--) {
            if (nums[i-1] < nums[i])
                nums[i-1] = nums[i];
            if (nums[i] != 0 && highestDigitNo == 0)
                highestDigitNo = i;
        }
    }

    private static void printNums() {
        for (int i = nums.length-1; i >= 0; i--) {
            System.out.print(nums[i]);
        }
        System.out.println("");
    }

    private static void printMaxNums() {
        for (int i = maxNums.length-1; i >= 0; i--) {
            System.out.print(maxNums[i]);
        }
        System.out.println("");
    }

    private static boolean lessThanMax() {
        for (int i = nums.length-1; i >= 0 ; i--) {
            if (nums[i] < maxNums[i])
                return true;
        }
        return false;
    }

    private static long estimateArmstrong() {
        //System.out.println("highestDigitNo="+highestDigitNo+" maxHighestDigitNo="+maxHighestDigitNo);
        for (int i = highestDigitNo; i <= maxHighestDigitNo+1; i++) {
            long sum = 0;
            long num = 0;
            for (int j = i; j >= 0; j--) {
                sum += pows[nums[j]][i+1];
                //System.out.println(" +"+pows[nums[j]][i+1]);
                num = 10 * num + nums[j];
            }
            //System.out.println("sum="+sum+" num="+num+" i="+i);
            if (getDigitSum(num) == getDigitSum(sum)) {
                String s1 = String.format("%"+(i+1)+"s", valueOf(num)).replace(" ", "0")
                        .chars()
                        .sorted()
                        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                        .toString();
                String s2 = valueOf(sum)
                        .chars()
                        .sorted()
                        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                        .toString();
                if (s1.equals(s2)) {
                    //System.out.println("adding "+sum);
                    return sum;
                }
            }
        }
        return 0L;
    }

}
