package sorm.core;

import sorm.bean.ColumnInfo;
import sorm.bean.Configuration;
import sorm.bean.TableInfo;
import sorm.util.JavaFileUtils;
import sorm.util.StringUtils;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *  负责管理数据库所有表结构与类结构之间的关系，并可以根据表结构生成类文件
 *  - 需要用Class加载类，但是一直找不到
 * @Date 2020/02/18 23:04
 * @Created by lan-mao.top
 */

public class TableContext {
    /**
     * 表名为key，表信息对象为value
     */
    public static Map<String, TableInfo> tables = new HashMap<>();
    /**
     * 将po的class对象名和表信息对象关联起来，便于重用！
     */
    public static  Map<String,TableInfo>  poClassTableMap = new HashMap<>();
    static {
        try {
            searchTableInfo();
            updateJavaPOFile();
            loadPOTables();
            compilerPOFile();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据表结构，重新生成Java文件
     */
    private static void updateJavaPOFile(){
        for (TableInfo tableInfo : tables.values()) {
            JavaFileUtils.createJavaPOFile(tableInfo, new MysqlTypeConverter());
        }
    }

    /**
     * 搜索数据库信息，获得数据库中所有表信息
     */
    private static void searchTableInfo() throws SQLException {
        //初始化获得表的信息
        Connection con = DBManager.getConnection();
        DatabaseMetaData dbData = con.getMetaData();
        Configuration conf = DBManager.getConf();
        String schema = conf.getSchema();
        ResultSet tableRet = dbData.getTables(schema, null,"%",new String[]{"TABLE"});

        while(tableRet.next()){
            String tableName = (String) tableRet.getObject("TABLE_NAME");

            TableInfo ti = new TableInfo(tableName,new HashMap<String, ColumnInfo>(), new ArrayList<ColumnInfo>());
            tables.put(tableName, ti);

            ResultSet set = dbData.getColumns(null, "%", tableName, "%");  //查询表中的所有字段
            while(set.next()){
                ColumnInfo ci = new ColumnInfo(set.getString("COLUMN_NAME"),
                        set.getString("TYPE_NAME"), false);
                ti.getColumns().put(set.getString("COLUMN_NAME"), ci);
            }

            ResultSet set2 = dbData.getPrimaryKeys(null, "%", tableName);  //查询t_user表中的主键
            while(set2.next()){
                ColumnInfo ci2 = (ColumnInfo) ti.getColumns().get(set2.getObject("COLUMN_NAME"));
                ci2.setPrimaryKey(true);  //设置为主键类型
                ti.getPriKeys().add(ci2);
            }

            if(ti.getPriKeys().size()>0){  //取唯一主键。。方便使用。如果是联合主键。则为空！
                ti.setOnlyPriKey(ti.getPriKeys().get(0));
            }
        }
        DBManager.close(con);
    }

    private static void loadPOTables() throws ClassNotFoundException {
        for (TableInfo tableInfo : tables.values()) {
            String clazz = DBManager.getConf().getPoPackage() + "." + StringUtils.toUpperCamelCase(tableInfo.getName());
            poClassTableMap.put(clazz, tableInfo );
        }
    }
    private static void compilerPOFile() throws ClassNotFoundException {
        for (String clazzPath : poClassTableMap.keySet()) {
            String filePath = DBManager.getConf().getSrcPath() + JavaFileUtils.pathSeparator + StringUtils.javaPath2FilePath(clazzPath) + ".java";
            JavaFileUtils.compilerJavaFile(filePath, DBManager.getConf().getClassPath());
        }
    }

}
