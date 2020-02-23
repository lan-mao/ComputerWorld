package sorm.bean;

/**
 * TODO 管理配置信息
 *
 * @Date 2020/02/18 23:26
 * @Created by lan-mao.top
 */

public class Configuration {
    /**
     * 驱动
     */
    private String driver;
    /**
     * 数据库链接
     */
    private String url ;
    /**
     * 模式名字
     */
    private String schema;
    /**
     * 数据库用户
     */
    private String user;
    /**
     * 密码
     */
    private String pwd ;
    /**
     * 使用的数据库类型
     */
    private String usingDB;
    /**
     * 使用的查询方法类
     */
    private String usingQueryClass;
    /**
     * 项目的源码路径
     */
    private String srcPath;
    /**
     * 扫描生成的JavaBean的包名(po is persistence object)
     */
    private String poPackage;
    /**
     * .java文件编译后的根目录
     */
    private String classPath;
    /**
     * 连接池最小数量
     */
    private Integer poolMin;
    /**
     * 连接池最大数量
     */
    private Integer poolMax;

    public String getClassPath() {
        return classPath;
    }

    public void setClassPath(String classPath) {
        this.classPath = classPath;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUsingDB() {
        return usingDB;
    }

    public void setUsingDB(String usingDB) {
        this.usingDB = usingDB;
    }

    public String getSrcPath() {
        return srcPath;
    }

    public void setSrcPath(String srcPath) {
        this.srcPath = srcPath;
    }

    public String getPoPackage() {
        return poPackage;
    }

    public void setPoPackage(String poPackage) {
        this.poPackage = poPackage;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public String getUsingQueryClass() {
        return usingQueryClass;
    }

    public void setUsingQueryClass(String usingQueryClass) {
        this.usingQueryClass = usingQueryClass;
    }

    public Integer getPoolMin() {
        return poolMin;
    }

    public void setPoolMin(Integer poolMin) {
        this.poolMin = poolMin;
    }

    public Integer getPoolMax() {
        return poolMax;
    }

    public void setPoolMax(Integer poolMax) {
        this.poolMax = poolMax;
    }

    public Configuration() {
    }

    @Override
    public String toString() {
        String sb = "Configuration{" + "driver='" + driver + '\'' +
                ", url='" + url + '\'' +
                ", schema='" + schema + '\'' +
                ", user='" + user + '\'' +
                ", pwd='" + pwd + '\'' +
                ", usingDB='" + usingDB + '\'' +
                ", usingQueryClass='" + usingQueryClass + '\'' +
                ", srcPath='" + srcPath + '\'' +
                ", poPackage='" + poPackage + '\'' +
                ", classPath='" + classPath + '\'' +
                ", poolMin=" + poolMin +
                ", poolMax=" + poolMax +
                '}';
        return sb;
    }
}
