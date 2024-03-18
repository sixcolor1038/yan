package com.yan.demo.infra.utils;

import java.awt.*;
import java.awt.datatransfer.*;
import java.io.File;
import java.io.IOException;

public class SystemClipboardUtils {

    /**
     * 将文本内容复制到系统剪贴板
     *
     * @param text 需要复制的文本内容
     */
    public static void setText(String text) {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(new StringSelection(text), null);
    }

    /**
     * 将文件复制到系统剪贴板
     *
     * @param file 需要复制的文件
     * @throws IOException
     */
    public static void setFile(File file) throws IOException {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(new FileTransferable(file), null);
    }

    /**
     * 从系统剪贴板中获取文本内容
     *
     * @return 系统剪贴板中的文本内容
     * @throws UnsupportedFlavorException
     * @throws IOException
     */
    public static String getText() throws UnsupportedFlavorException, IOException {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable contents = clipboard.getContents(null);
        if (contents != null && contents.isDataFlavorSupported(DataFlavor.stringFlavor)) {
            return (String) contents.getTransferData(DataFlavor.stringFlavor);
        } else {
            return null;
        }
    }

    /**
     * 从系统剪贴板中获取文件
     *
     * @return 系统剪贴板中的文件
     * @throws UnsupportedFlavorException
     * @throws IOException
     */
    public static File getFile() throws UnsupportedFlavorException, IOException {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable contents = clipboard.getContents(null);
        if (contents != null && contents.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
            java.util.List<File> fileList = (java.util.List<File>) contents.getTransferData(DataFlavor.javaFileListFlavor);
            if (fileList.size() > 0) {
                return fileList.get(0);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * 封装文件类型，支持剪贴板传输
     */
    private static class FileTransferable implements Transferable {
        private File file;

        public FileTransferable(File file) {
            this.file = file;
        }

        @Override
        public DataFlavor[] getTransferDataFlavors() {
            return new DataFlavor[]{DataFlavor.javaFileListFlavor};
        }

        @Override
        public boolean isDataFlavorSupported(DataFlavor flavor) {
            return flavor.equals(DataFlavor.javaFileListFlavor);
        }

        @Override
        public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
            if (flavor.equals(DataFlavor.javaFileListFlavor)) {
                return java.util.Collections.singletonList(file);
            } else {
                throw new UnsupportedFlavorException(flavor);
            }
        }
    }
}
