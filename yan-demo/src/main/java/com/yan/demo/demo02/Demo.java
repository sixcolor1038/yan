package com.yan.demo.demo02;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * @Author: sixcolor
 * @Date: 2024-03-11 19:21
 * @Description:
 */
public class Demo {

    public static void main(String[] args) {
       String a = "a,b";
       String b = "a,b";
        System.out.println(a.equals(b));
    }

    private static void extracted() {

        double num1 = Math.pow(199, 200);
        double num2 = Math.pow(200, 199);

        if (num1 > num2) {
            System.out.println("199的200次方大于200的199次方");
        } else if (num1 < num2) {
            System.out.println("199的200次方小于200的199次方");
        } else {
            System.out.println("199的200次方等于200的199次方");
        }
    }


    private static void method3() {
        int n = 100000000;
        int[] arr = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(n);
        }

        long startTime = System.currentTimeMillis();
        int[] topK = findTopK(arr, 1);
        long endTime = System.currentTimeMillis();
        System.out.println("Top 10 numbers: " + Arrays.toString(topK));
        System.out.println("本次查询耗时: {" + (endTime - startTime) + "} 毫秒");
    }

    private static int[] findTopK(int[] arr, int k) {
        int[] topK = new int[k];
        for (int i = 0; i < k; i++) {
            topK[i] = arr[i];
        }
        Arrays.sort(topK);
        for (int i = k; i < arr.length; i++) {
            if (arr[i] > topK[0]) {
                topK[0] = arr[i];
                int j = 1;
                while (j < k && topK[j] < topK[j - 1]) {
                    swap(topK, j, j - 1);
                    j++;
                }
            }
        }
        return topK;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    private static void method2() {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        System.out.println("1加到100的和：" + sum);
    }


    private static void method1() {
        int[] arr = {78, 53, 82, 56, 97, 72, 63};
        int num = arr[0];
        for (int j : arr) {
            if (j > num) {
                num = j;
            }
        }
        System.out.println("最大数：" + num);
    }

    private static void me() {
        int[] nums = {11, 3, 998, 5455, 1, 152, 990};

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(
                Arrays.stream(nums)
                        .mapToObj(num -> CompletableFuture.runAsync(() -> {
                            try {
                                Thread.sleep(num);
                                System.out.println(num);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }))
                        .toArray(CompletableFuture[]::new)
        );
        allFutures.join();
    }


    public static int[] solve(int[] digits) {
        int left = 0, right = digits.length - 1;
        while (left < right) {
            int temp = digits[left];
            digits[left] = digits[right];
            digits[right] = temp;
            left++;
            right--;
        }
        int diff = 0;
        for (int digit : digits) {
            diff = diff * 10 + digit;
        }
        int[] result = new int[digits.length];
        int i = 0;
        if (diff == 0) {
            result[i++] = 0;
        }
        while (diff > 0) {
            result[i++] = diff % 10;
            diff /= 10;
        }
        return Arrays.copyOf(result, i);
    }


    private static void extracted3() {
        String[] arr = {"a", "b", "c", "a", "b", "d"};
        String[] newArr = new String[arr.length];
        int index = 0;
        for (String s : arr) {
            if (!Arrays.asList(newArr).contains(s)) {
                newArr[index++] = s;
            }
        }
        newArr = Arrays.copyOf(newArr, index);
        System.out.println(Arrays.toString(newArr));
    }

    private static void extracted2() {
        List<String> asList = Arrays.asList("1", "2", "3", "4", "5", "6");
        int currentPageNumber = 2;//当前页
        int pageMaxSize = 5;//每页条数
        List<String> collect1 = asList.stream().skip((long) (currentPageNumber - 1) * pageMaxSize).limit(pageMaxSize).collect(Collectors.toList());
        //System.out.println(JSONUtils.toJSONString(collect1));
    }
}
