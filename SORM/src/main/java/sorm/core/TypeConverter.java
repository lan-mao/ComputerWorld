package sorm.core;

/**
 *  负责Java数据类型和数据库数据类型的互相转化
 *
 * @Date 2020/02/18 22:59
 * @Created by lan-mao.top
 */

public interface TypeConverter {
    /**
     * 将java数据类型转换为数据库类型
     * @param javaDataType java的数据类型
     * @return 数据库字段的数据类型
     */
    String javaType2DatabaseType(String javaDataType);
    /**
     * 将数据库类型转换为java数据类型
     * @param columnType 数据库字段的数据类型
     * @return java数据类型
     */
    String databaseType2JavaType(String columnType);
}
