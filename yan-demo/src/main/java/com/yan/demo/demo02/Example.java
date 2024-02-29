package com.yan.demo.demo02;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Example {
    public static void main(String[] args) {
        Map<String, List<VO>> map = new HashMap<>();

        // 假设有一些数据
        List<VO> voList1 = Arrays.asList(
                new VO(1, "Alice", "Female"),
                new VO(2, "Bob", "Male")
        );
        List<VO> voList2 = Arrays.asList(
                new VO(3, "Charlie", "Male"),
                new VO(4, "Diana", "Female")
        );

        map.put("key1", voList1);
        map.put("key2", voList2);

        // 使用 forEach 迭代 Map，并对值进行操作
        map.forEach((key, valueList) -> {
            System.out.println("Key: " + key);
            // 对每个值列表进行迭代
            valueList.forEach(vo -> {
                // 在这里对每个 VO 进行操作，例如打印其属性值
                System.out.println("ID: " + vo.getId() + ", Name: " + vo.getName() + ", Gender: " + vo.getGender());
            });
        });
    }
}

class VO {
    private int id;
    private String name;
    private String gender;

    public VO(int id, String name, String gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }
}


