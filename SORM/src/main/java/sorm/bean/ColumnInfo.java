package sorm.bean;

/**
 * TODO 封装字段信息
 *
 * @Date 2020/02/18 23:12
 * @Created by lan-mao.top
 */

public class ColumnInfo {
    /**
     * 字段名称
     */
    private String name;
    /**
     * 字段的数据类型
     */
    private String dataType;
    /**
     * 是否是主键
     */
    private boolean primaryKey = false;

    public ColumnInfo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public boolean isPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(boolean primaryKey) {
        this.primaryKey = primaryKey;
    }

    public ColumnInfo(String name, String dataType, boolean primaryKey) {
        this.name = name;
        this.dataType = dataType;
        this.primaryKey = primaryKey;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ColumnInfo{");
        sb.append("name='").append(name).append('\'');
        sb.append(", dataType='").append(dataType).append('\'');
        sb.append(", primaryKey=").append(primaryKey);
        sb.append('}');
        return sb.toString();
    }
}
