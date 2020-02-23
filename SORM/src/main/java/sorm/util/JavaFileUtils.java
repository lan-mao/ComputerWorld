package sorm.util;

import sorm.bean.ColumnInfo;
import sorm.bean.JavaFiledGetSet;
import sorm.bean.TableInfo;
import sorm.core.DBManager;
import sorm.core.TypeConverter;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * TODO 封装Java源文件操作
 *
 * @Date 2020/02/18 23:08
 * @Created by lan-mao.top
 */

public class JavaFileUtils {
    public static final String pathSeparator = "/";
    /**
     * 跟句字段信息生成Java属性信息，如：varchar username--->private String username;以及set和get方法源码
     * @param columnInfo 字段信息
     * @param typeConverter 类型转换器
     * @return 返回字段对应的JavaBean源代码
     */
    public static JavaFiledGetSet createFiledGetSerSRC(ColumnInfo columnInfo, TypeConverter typeConverter){
        JavaFiledGetSet javaFiledGetSet = new JavaFiledGetSet();
        String javaFieldType = typeConverter.databaseType2JavaType(columnInfo.getDataType());
        javaFiledGetSet.setFieldInfo(String.format("\tprivate %s %s ;\n", javaFieldType, StringUtils.toLowerCamelCase(columnInfo.getName())));
        // public String getUserName (){return username;}
        javaFiledGetSet.setGetInfo(String.format("\tpublic %s get%s(){\n\t\treturn %s;\n\t}\n",
                javaFieldType, StringUtils.toUpperCamelCase(columnInfo.getName()), StringUtils.toLowerCamelCase(columnInfo.getName())));
        //public void setUserName(String userName){this.userName = userName;}
        javaFiledGetSet.setSetInfo(String.format(
                "\tpublic void set%s(%s %s){\n\t\tthis.%s = %s;\n\t}\n",
                StringUtils.toUpperCamelCase(columnInfo.getName()), javaFieldType, StringUtils.toLowerCamelCase(columnInfo.getName()),StringUtils.toLowerCamelCase(columnInfo.getName()),StringUtils.toLowerCamelCase(columnInfo.getName())
                ));
        return javaFiledGetSet;
    }

    /**
     * 根据表信息生成Java源代码
     * @param tableInfo 表信息
     * @param typeConverter 类型转换器
     * @return 表对应的Java源代码
     */
    public static String createJavaSrc(TableInfo tableInfo, TypeConverter typeConverter){
        Map<String, ColumnInfo> columns = tableInfo.getColumns();
        List<JavaFiledGetSet> javaFiledList = new ArrayList<>();
        for (ColumnInfo columnInfo : columns.values()) {
            javaFiledList.add(createFiledGetSerSRC(columnInfo, typeConverter));
        }
        StringBuilder sb = new StringBuilder();
        //package
        sb.append(String.format("package %s;\n\n", DBManager.getConf().getPoPackage()));
        //import
        sb.append("import java.sql.*;\nimport java.util.*;\n\n");
        //类声明
        sb.append(String.format("public class %s {\n\n",StringUtils.toUpperCamelCase(tableInfo.getName())));
        //属性列表
        for (JavaFiledGetSet javaFiledGetSet : javaFiledList) {
            sb.append(javaFiledGetSet.getFieldInfo());
        }
        sb.append("\n");
        //get方法列表
        for (JavaFiledGetSet javaFiledGetSet : javaFiledList) {
            sb.append(javaFiledGetSet.getGetInfo());
        }
        //set方法列表
        for (JavaFiledGetSet javaFiledGetSet : javaFiledList) {
            sb.append(javaFiledGetSet.getSetInfo());
        }
        //结束｝
        sb.append("}");
        return sb.toString();
    }

    /**
     * 根据表信息生成java文件
     * @param tableInfo 表信息
     * @param typeConverter 类型转换器
     */
    public static void createJavaPOFile(TableInfo tableInfo, TypeConverter typeConverter){
        String javaSrc = createJavaSrc(tableInfo, typeConverter);
        String srcPath = DBManager.getConf().getSrcPath();
        String packagePath = StringUtils.javaPath2FilePath(DBManager.getConf().getPoPackage());
        String filePackagePath = null;
        if (pathSeparator.equals(srcPath.substring(srcPath.length() - 1))) {
            filePackagePath = srcPath + packagePath;
        } else {
            filePackagePath = srcPath + pathSeparator + packagePath;
        }
        File filePackage = new File(filePackagePath);
        if (!filePackage.exists()) {
            filePackage.mkdirs();
        }
        File file = new File(filePackage, StringUtils.toUpperCamelCase(tableInfo.getName() + ".java"));
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));){
            bufferedWriter.write(javaSrc);
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 编译对应路径的.java文件，在指定的编译路径下生成“包名/类名.class”文件
     * @param javaFilePath 要编译的.java文件路径
     * @param classOutPath 要输出的.class文件的文件夹路径根路径
     * @return 返回是否编译成功了
     */
    public static Boolean compilerJavaFile(String javaFilePath, String classOutPath){
        JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
        ////直接编译当java文件的目录下
        //int result = javaCompiler.run(null, null, null, javaFilePath);
        //设置指定的参数列表
        Iterable<String> options = Arrays.asList("-d", classOutPath);
        //获取一个文件管理器，对应的参数为诊断侦听器、区域化设置、字符集。为空都代表默认
        StandardJavaFileManager fileManager = javaCompiler.getStandardFileManager(null, null, null);
        //使用文件管理器获得文件游标
        Iterable<? extends JavaFileObject> compilationUnits = fileManager.getJavaFileObjectsFromFiles(Arrays.asList(new File(javaFilePath)));
        //获取一个编译任务，对应的参数如下
        //out - 编写器用于编译器的附加输出; 使用System.err如果null
        //fileManager - 文件管理器; 如果null使用编译器的标准文件管理器
        //diagnosticListener - 诊断听众; 如果null使用编译器的默认方法来报告诊断
        //options - 编译器选项， null表示没有选项
        //classes - 通过注释处理 null类的名称， null表示没有类名
        //compilationUnits - 编译单元， null表示无编译单位
        JavaCompiler.CompilationTask task = javaCompiler.getTask(null, fileManager, null, options, null, compilationUnits);
        Boolean aBoolean = task.call();
        return aBoolean;
    }
}
