package com.yan.demo.demo02;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileCopy {

    public static void main(String[] args) {
        copyTemplate();
    }

    public static void copyTemplate() {
        String sourceFileName = "测试.xlsx";
        String sourceFilePath = "src/main/resources/doc/" + sourceFileName; // 模板文件在 resources/doc 目录下
        String destinationDirectory = "D:\\"; // 下载目录

        try {
            Path sourcePath = Paths.get(sourceFilePath);
            Path destinationPath = Paths.get(destinationDirectory + sourceFileName);

            // 检查目标目录是否存在，不存在则创建
            Path dir = Paths.get(destinationDirectory);
            if (!Files.exists(dir)) {
                Files.createDirectories(dir);
            }

            Files.copy(sourcePath, destinationPath);
            System.out.println("文件复制成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


