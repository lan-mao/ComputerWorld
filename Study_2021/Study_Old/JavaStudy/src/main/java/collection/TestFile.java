package collection;

import java.io.File;

/**
 * 使用递归算法打印目录结构
 */
public class TestFile {
    public static void main(String[] args) {
        //System.out.println(File.separator);
        File file = new File("");
        printFileTree(file,0);
    }
    static void printFileTree(File file,int level){
        if (level > 6) return;
        for (int i = 0; i < level; i++) {
            System.out.print("--");
        }
        System.out.println(file.getName());
        if (file.isDirectory()&&file.canRead()&&file.list().length >0 ){
            File[] files = file.listFiles();

            for (File temp : files) {
                String filename = temp.getName();
                String fileType = filename.substring(temp.getName().lastIndexOf('.') + 1);
                if (!fileType.equals("png")&&!fileType.equals("jpg")&&!fileType.equals("PNG")&&!fileType.equals("JPG")) {
                    printFileTree(temp, level + 1);
                }
            }
        }
    }
}
