package sorm.bean;

import java.util.List;
import java.util.Map;

/**
 *  封装表结构信息
 *
 * @Date 2020/02/18 23:27
 * @Created by lan-mao.top
 */

public class TableInfo {
    /**
     * 表名
     */
    private String name;
    /**
     * 表的字段信息
     */
    private Map<String, ColumnInfo> columns;
    /**
     * 表中的主键信息（只处理有且只有一个的表主键）
     */
    private ColumnInfo onlyPriKey;
    /**
     * 如果联合主键，则在这里存储
     */
    private List<ColumnInfo> priKeys;

    public TableInfo() {
    }

    public TableInfo(String name, Map<String, ColumnInfo> columns, List<ColumnInfo> priKeys) {
        this.name = name;
        this.columns = columns;
        this.priKeys = priKeys;
    }

    public TableInfo(String name, Map<String, ColumnInfo> columns, ColumnInfo onlyPriKey, List<ColumnInfo> priKeys) {
        this.name = name;
        this.columns = columns;
        this.onlyPriKey = onlyPriKey;
        this.priKeys = priKeys;
    }

    public List<ColumnInfo> getPriKeys() {
        return priKeys;
    }

    public void setPriKeys(List<ColumnInfo> priKeys) {
        this.priKeys = priKeys;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, ColumnInfo> getColumns() {
        return columns;
    }

    public void setColumns(Map<String, ColumnInfo> columns) {
        this.columns = columns;
    }

    public ColumnInfo getOnlyPriKey() {
        return onlyPriKey;
    }

    public void setOnlyPriKey(ColumnInfo onlyPriKey) {
        this.onlyPriKey = onlyPriKey;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TableInfo{");
        sb.append("name='").append(name).append('\'');
        sb.append(", columns=").append(columns);
        sb.append(", onlyPriKey=").append(onlyPriKey);
        sb.append(", priKeys=").append(priKeys);
        sb.append('}');
        return sb.toString();
    }
}
