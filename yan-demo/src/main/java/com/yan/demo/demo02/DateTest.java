package com.yan.demo.demo02;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DateTest {
    public static void main(String[] args) {
        // 创建一个实体类，用于存储人员信息
        class Person {
            private String name;

            public Person(String name) {
                this.name = name;
            }

            public String getName() {
                return name;
            }
        }

        // 假设您已经有了一个存储了每天人员信息的列表
        List<Person>[] peopleByDay = new List[7];
        // 这里假设 peopleByDay[0] 表示1号的人员信息，以此类推

        // 假设您已经填充了这个列表，例如：
        peopleByDay[0] = Arrays.asList(new Person("张三"), new Person("李四"));
        peopleByDay[1] = Arrays.asList(new Person("王五"), new Person("赵六"));
        peopleByDay[2] = Arrays.asList(new Person("钱七"), new Person("孙八"));
        peopleByDay[3] = Arrays.asList(new Person("周九"), new Person("吴十"));
        peopleByDay[4] = Arrays.asList(new Person("郑十一"), new Person("王十二"));
        peopleByDay[5] = Arrays.asList(new Person("冯十三"), new Person("陈十四"));
        peopleByDay[6] = Arrays.asList(new Person("楚十五"), new Person("魏十六"));


        // 创建一个映射来存储日期和对应的人员信息
        Map<Integer, List<Person>> map = new HashMap<>();

        // 假设从1号开始遍历到7号
        for (int i = 0; i < 7; i++) {
            map.put(i + 1, peopleByDay[i]);
        }

        // 查询特定日期对应的人员信息
        int targetDay = 6;
        List<Person> peopleOnTargetDay = map.get(targetDay);

        if (peopleOnTargetDay != null) {
            System.out.println("在 " + targetDay + " 号的人员信息是:");
            for (Person person : peopleOnTargetDay) {
                System.out.println(person.getName());
            }
        } else {
            System.out.println(targetDay + " 号没有人员信息。");
        }
    }
}

