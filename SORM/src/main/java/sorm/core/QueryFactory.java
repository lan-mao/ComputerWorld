package sorm.core;

import java.lang.reflect.InvocationTargetException;

/**
 *  提供返回Query对象的方法
 *
 * @Date 2020/02/18 22:58
 * @Created by lan-mao.top
 */

public class QueryFactory {
    private volatile static Query query;//原型对象
    static {
        try {
            Class.forName("sorm.core.DBManager");
            Class.forName("sorm.core.TableContext");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String usingQueryClass = DBManager.getConf().getUsingQueryClass();
        if (usingQueryClass!=null){
            try {
                Class clazz = Class.forName(usingQueryClass);
                query = (Query)clazz.getConstructor().newInstance();
            } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        } else {
            String usingDB = DBManager.getConf().getUsingDB();
            switch (usingDB){
                case "mysql":{
                    query = new MysqlQuery();
                    break;
                }
                case "oracle":{
                    query = new OracleQuery();
                    break;
                }
                default:{
                    query = new Query() {
                        @Override
                        public Object queryPaging(int pageNum, int size) {
                            return null;
                        }
                    };
                    break;
                }
            }
        }
    }

    private QueryFactory(){}

    public static Query createQuery(){
        try {
            return (Query) query.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {

    }
}
