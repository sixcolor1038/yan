package com.yan.demo.demo02;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: sixcolor
 * @Date: 2024-03-12 10:17
 * @Description:
 */
public class SpliceDemo {
    public static void main(String[] args) {
        spliceStr();
    }

    private static void spliceStr() {
        List<PersonSplice> personList = Arrays.asList(
                new PersonSplice(1, "John", 30, "01", "a"),
                new PersonSplice(2, "Alice", 25, "02", "b"),
                new PersonSplice(3, "Bob", 40, "01", "c")
        );

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < personList.size(); i++) {
            if ("01".equals(personList.get(i).getAnswer())) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append(",");
                }
                stringBuilder.append(personList.get(i).getKey());
            }
        }

        String answer = stringBuilder.toString();
        System.out.println(answer); //输出：a,c
    }
}

@Data
@AllArgsConstructor
class PersonSplice {
    private int id;
    private String name;
    private int age;
    private String answer;
    private String key;
}
