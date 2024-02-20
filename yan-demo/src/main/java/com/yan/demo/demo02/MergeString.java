package com.yan.demo.demo02;

/**
 * @Author: sixcolor
 * @Date: 2024-02-20 9:37
 * @Description:
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

public class MergeString {
    public static void main(String[] args) {
        // 假设你有一个名为inputList的List，其中包含了前端传来的数据
        List<Item> inputList = new ArrayList<>();
        // 示例数据
        inputList.add(new Item(1, "2024-02-20", "Morning", "John"));
        inputList.add(new Item(2, "2024-02-20", "Morning", "Alice"));
        inputList.add(new Item(3, "2024-02-20", "Afternoon", "Bob"));
        inputList.add(new Item(4, "2024-02-21", "Morning", "Charlie"));
        inputList.add(new Item(5, "2024-02-21", "Morning", "David"));
        inputList.add(new Item(6, "2024-02-21", "Afternoon", "Eve"));
        // 假设有一个名为mergedList的List，用于存储合并后的结果
        List<Item> mergedList = mergeItems(inputList);

        // 打印合并后的结果
        for (Item item : mergedList) {
            System.out.println(item);
        }
    }

    public static List<Item> mergeItems(List<Item> inputList) {
        Map<String, List<Item>> map = new HashMap<>();

        // 遍历inputList，将相同日期和时段的项合并到同一个日期和时段的列表中
        for (Item item : inputList) {
            String key = item.getDate() + "_" + item.getTimePeriod();
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(item);
        }

        // 构建合并后的结果列表
        List<Item> mergedList = new ArrayList<>();
        for (List<Item> itemList : map.values()) {
            // 对于每个日期和时段的列表，合并其中的项
            Item mergedItem = mergeItemList(itemList);
            mergedList.add(mergedItem);
        }

        return mergedList;
    }

    // 合并同一日期和时段的项
    public static Item mergeItemList(List<Item> itemList) {
        Item mergedItem = new Item();
        // 在这里实现合并逻辑，例如取第一个项的id和日期、时段，以及将所有的name合并等
        // 这里只是一个示例，你需要根据具体的业务逻辑来实现
        if (!itemList.isEmpty()) {
            Item firstItem = itemList.get(0);
            mergedItem.setId(firstItem.getId());
            mergedItem.setDate(firstItem.getDate());
            mergedItem.setTimePeriod(firstItem.getTimePeriod());

            StringBuilder names = new StringBuilder();
            for (Item item : itemList) {
                names.append(item.getName()).append(", ");
            }
            // 去除最后的逗号和空格
            String mergedNames = names.substring(0, names.length() - 2);
            mergedItem.setName(mergedNames);
        }

        return mergedItem;
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Item {
    private int id;
    private String date;
    private String timePeriod;
    private String name;

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", timePeriod='" + timePeriod + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
