package sorm.core;

/**
 * @Date 2020/02/19 12:43
 * @Created by lan-mao.top
 *  Mysql数据库数据类型转为Java数据类型
 */

public class MysqlTypeConverter implements TypeConverter {
    @Override
    public String javaType2DatabaseType(String javaDataType) {
        return null;
    }

    @Override
    public String databaseType2JavaType(String columnType) {
        columnType = columnType.toLowerCase();
        switch (columnType){
            case "char":
            case "varchar":
                return "String";
            case "int":
            case "smallint":
            case "tinyint":
            case "integer":
                return "Integer";
            case "bigint":
                return "Long";
            case "double":
            case "float":
                return "Double";
            case "clob":
                return "java.sql.Clob";
            case "blob":
                return "java.sql.Blob";
            case "date":
                return "java.sql.Date";
            case "datetime":
            case "timestamp":
                return "java.sql.Timestamp";
            case "time":
                return "java.sql.Time";
            case "enum":
                return "Enum";
        }
        return null;
    }
}
