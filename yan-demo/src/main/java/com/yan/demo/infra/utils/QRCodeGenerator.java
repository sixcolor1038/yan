package com.yan.demo.infra.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: sixcolor
 * @Date: 2024-02-22 9:12
 * @Description:
 */
public class QRCodeGenerator {

    public static void generateQRCode(String text, String filePath) throws WriterException, IOException {
        // 设置二维码内容
        String qrCodeData = text;

        // 设置二维码参数
        Map<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8"); // 指定字符编码
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L); // 错误纠正级别（可选：L/M/Q/H）

        // 创建二维码写码器
        QRCodeWriter qrCodeWriter = new QRCodeWriter();

        // 生成矩阵 BitMatrix
        BitMatrix bitMatrix = qrCodeWriter.encode(qrCodeData, BarcodeFormat.QR_CODE, 200, 200, hints); // 定义二维码的宽高为200像素

        // 将BitMatrix转换为BufferedImage
        MatrixToImageConfig config = new MatrixToImageConfig(Color.BLACK.getRGB(), Color.WHITE.getRGB()); // 设置前景色和背景色
        BufferedImage image = MatrixToImageWriter.toBufferedImage(bitMatrix, config);

        // 将BufferedImage保存为图片文件
        Path path = Paths.get(filePath);
        MatrixToImageWriter.writeToFile(bitMatrix, "PNG", path.toFile()); // 保存为PNG格式图片
    }

    public static void main(String[] args) throws WriterException, IOException {
        String content = "https://example.com";
        String outputFilePath = "D:/tmp/output.png";
        generateQRCode(content, outputFilePath);
        System.out.println("二维码已生成并保存至：" + outputFilePath);
    }
}