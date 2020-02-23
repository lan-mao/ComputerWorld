package sorm.bean;

/**
 * @Date 2020/02/19 19:12
 * @Created by lan-mao.top
 * TODO 封装了Java属性和get、set方法的源代码
 */

public class JavaFiledGetSet {
    /**
     * 属性的源码信息：如：private int userId;
     */
    private String fieldInfo;
    /**
     * get方法的源码信息，如：public int getUserId(){}
     */
    private String getInfo;
    /**
     * set方法的源码信息，如：public void setUserId(int id){this.id = id}
     */
    private String setInfo;

    public JavaFiledGetSet(String fieldInfo, String getInfo, String setInfo) {
        this.fieldInfo = fieldInfo;
        this.getInfo = getInfo;
        this.setInfo = setInfo;
    }

    public JavaFiledGetSet() {
    }

    public String getFieldInfo() {
        return fieldInfo;
    }

    public void setFieldInfo(String fieldInfo) {
        this.fieldInfo = fieldInfo;
    }

    public String getGetInfo() {
        return getInfo;
    }

    public void setGetInfo(String getInfo) {
        this.getInfo = getInfo;
    }

    public String getSetInfo() {
        return setInfo;
    }

    public void setSetInfo(String setInfo) {
        this.setInfo = setInfo;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append(fieldInfo);
        sb.append(getInfo);
        sb.append(setInfo);
        return sb.toString();
    }
}
