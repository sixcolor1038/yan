package com.yan.demo.demo02;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Author: sixcolor
 * @Date: 2024-03-01 16:19
 * @Description:
 */


public class FilterRepeat {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Alice", "25"),
                new Person("Bob", "30"),
                new Person("Charlie", "25"),
                new Person("David", "30")
        );

        // 将年龄转换为Integer并找出重复的年龄
        Map<Integer, Long> duplicateAges = people.stream()
                .map(Person::getAgeAsInteger) // 转换为Integer流
                .filter(Objects::nonNull) // 去除无效年龄格式的数据
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1) // 选出数量大于1的，即重复的年龄
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        // 打印出重复的年龄及其出现次数
        duplicateAges.forEach((age, count) -> {
            System.out.println("重复的年龄:Age: " + age + ", Count: " + count);
        });

        // 先将年龄转换为Integer，然后排序
        List<Person> sortedByAge = people.stream()
                .filter(p -> p.getAgeAsInteger() != null) // 去除无效年龄格式的数据
                .sorted(Comparator.comparing(Person::getAgeAsInteger))
                .toList();

        // 打印出按照年龄排序后的Person对象
        sortedByAge.forEach(person -> System.out.println("按照年龄排序:Name: " + person.getName() + ", Age: " + person.getAge()));
    }
}

@Data
@AllArgsConstructor
class Person {
    String name;
    String age;

    // 添加一个辅助方法，将年龄String转换为Integer
    public Integer getAgeAsInteger() {
        try {
            return Integer.parseInt(age);
        } catch (NumberFormatException e) {
            System.err.println("Invalid age format: " + age);
            return null; // 或者返回一个特殊值，取决于你的处理策略
        }
    }
}
