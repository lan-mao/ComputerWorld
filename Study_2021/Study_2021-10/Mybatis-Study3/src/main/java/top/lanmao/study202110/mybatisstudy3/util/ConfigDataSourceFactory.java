package top.lanmao.study202110.mybatisstudy3.util;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;

/**
 * Create Date 2021/11/23 16:30:45 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */
public class ConfigDataSourceFactory extends PooledDataSourceFactory {

    public ConfigDataSourceFactory() {
        this.dataSource = new DruidDataSource();
    }
}