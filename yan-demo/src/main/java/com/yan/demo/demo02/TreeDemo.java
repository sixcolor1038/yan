package com.yan.demo.demo02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TreeNode {
    private String id;
    private String name;
    private String fid;
    private String type;
    private List<TreeNode> children;

    public TreeNode(String id, String name, String fid, String type) {
        this.id = id;
        this.name = name;
        this.fid = fid;
        this.type = type;
        this.children = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", fid='" + fid + '\'' +
                ", type='" + type + '\'' +
                ", children=" + children +
                '}';
    }

    public String getFid() {
        return fid;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void addChild(TreeNode child) {
        children.add(child);
    }

    public boolean hasChildren() {
        return !children.isEmpty();
    }
}

public class TreeDemo {
    public static void main(String[] args) {
        // 模拟输入数据
        List<TreeNode> input = new ArrayList<>();
        input.add(new TreeNode("1", "ifdas", "0", "im"));
        input.add(new TreeNode("2", "fad", "1", "em"));
        input.add(new TreeNode("3", "asf", "0", "tm"));

        // 构建树状结构并输出结果
        List<TreeNode> result = buildTree(input);
        for (TreeNode node : result) {
            printTree(node, 0);
        }
    }

    public static List<TreeNode> buildTree(List<TreeNode> input) {
        Map<String, TreeNode> nodeMap = new HashMap<>();

        for (TreeNode node : input) {
            nodeMap.put(node.getId(), node);
        }

        List<TreeNode> roots = new ArrayList<>();

        for (TreeNode node : input) {
            String fid = node.getFid();
            TreeNode parent = nodeMap.get(fid);
            if (parent != null) {
                parent.addChild(node);
            } else {
                roots.add(node);
            }
        }

        return roots;
    }

    public static void printTree(TreeNode node, int level) {
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < level; i++) {
            indent.append("  ");
        }
        System.out.println(indent.toString() + node.getName());

        for (TreeNode child : node.getChildren()) {
            printTree(child, level + 1);
        }
    }
}
