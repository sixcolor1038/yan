package com.yan.demo.lambdademo;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;


public class Demo1 {
    private static final Logger logger = LoggerFactory.getLogger(Demo1.class);

    public static void main(String[] args) {
        String version = "1.2.3-beta.1";

        System.out.println(getVersionNumbers(version));
    }


    /**
     * 从版本字符串中提取数字
     *
     * @param str 版本字符串
     * @return 只包含数字的版本号
     */
    public static String getVersionNumbers(String str) {

        return str.replaceAll("\\D+", "");

    }

    /**
     * 使用函数式接口进行操作
     * 编写一个函数式接口 StringOperation，其中包含一个抽象方法 String operate(String str)，
     * 然后使用Lambda表达式实现以下操作：
     * 将字符串全部转为大写。
     * 将字符串全部转为小写。
     * 去除字符串两端的空格。
     */

    /**
     * 函数式接口的使用
     * 编写一个函数式接口 MathOperation，
     * 其中包含一个抽象方法 int operate(int a, int b)，
     * 然后使用Lambda表达式实现加法、减法、乘法和除法操作。
     */
    private static void mathOperationTest(int a,int b) {
        performOperation("Addition", MathOperations.addition(), a, b);
        performOperation("Subtraction", MathOperations.subtraction(), a, b);
        performOperation("Multiplication", MathOperations.multiplication(), a, b);
        performOperation("Division", MathOperations.division(), a, b);
    }

    private static void performOperation(String operationName, MathOperation operation, int a, int b) {
        try {
            int result = operation.operate(a, b);
            System.out.println(operationName + " Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println(operationName + " Error: " + e.getMessage());
        }
    }

    /**
     * 处理集合中的空值
     * 给定一个字符串列表，其中可能包含空值（null），使用Lambda表达式过滤出不为空的字符串，并打印出结果。
     */
    private static void filterNull() {
        List<String> list = new ArrayList<>();
        list.add("yan");
        list.add("good");
        list.add("ten");
        list.add(null);
        list.add("");
        list.add(" ");
        list.add("好");
        list.add("null");
        System.out.println(list); //[yan, good, ten, null, ,  , 好, null]
        list.stream().filter(StringUtils::isNotBlank).forEach(System.out::println);//yan good ten 好 null
    }

    /**
     * 对字符串列表排序
     * 给定一个字符串列表，使用Lambda表达式将列表按字母顺序进行排序，并打印排序后的结果。
     */
    private static void sortTest() {
        List<String> list = new ArrayList<>();
        list.add("student");
        list.add("apple");
        list.add("banana");
        list.add("x");
        list.add("y");
        System.out.println(list);//[student, apple, banana, x, y]
        list.stream().sorted().forEach(System.out::println);//apple banana student x y
    }

    /**
     * 计算元素之和
     * 给定一个整数列表，使用Lambda表达式计算列表中所有元素的和。
     */
    private static void sumTest() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(15);
        list.add(98);
        int sum = list.stream().mapToInt(Integer::intValue).sum();
        System.out.println("sum:" + sum);//114
    }

    /**
     * 筛选满足条件的元素
     * 给定一个字符串列表，使用Lambda表达式筛选出长度大于5的字符串，并将它们打印出来。
     */
    private static void filterTest() {
        List<String> list = new ArrayList<>();
        list.add("student");
        list.add("apple");
        list.add("banana");
        list.add("x");
        list.add("y");
        list.stream().filter(x -> x.length() > 5).forEach(System.out::println);
    }

    /**
     * 对列表中的元素进行平方操作
     * 给定一个整数列表，使用Lambda表达式对列表中的每个元素进行平方，然后打印出结果。
     */
    private static void squareTest() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list.forEach(x -> System.out.println(x * x));
    }
}

@FunctionalInterface
interface MathOperation {
    int operate(int a, int b);
}
class MathOperations {
    public static MathOperation addition() {
        return Integer::sum;//(a, b) -> a + b
    }

    public static MathOperation subtraction() {
        return (a, b) -> a - b;
    }

    public static MathOperation multiplication() {
        return (a, b) -> a * b;
    }

    public static MathOperation division() {
        return (a, b) -> {
            if (b == 0) {
                throw new ArithmeticException("不能除以0");
            }
            return a / b;
        };
    }
}
