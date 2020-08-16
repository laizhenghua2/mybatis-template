package com.howie.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtil {
    private static SqlSessionFactory sqlSessionFactory;
    // 静态代码块的特点：随着类的加载而加载，并且只执行一次
    static {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    private SqlSessionUtil(){} // 单例模式

    // 设置共享变量，供每个线程使用(保证session唯一)
    private static ThreadLocal<SqlSession> t = new ThreadLocal<SqlSession>();
    // 获取SqlSession对象
    public static SqlSession getSession(){
        SqlSession session = t.get(); // get() 方法：获取与当前线程关联的ThreadLocal值
        if(session == null){
            session = sqlSessionFactory.openSession();
            t.set(session);
        }
        return session;
    }
    // 关闭SqlSession对象
    public static void closeSession(SqlSession session){
        if(session != null){
            session.close();
            t.remove(); // remove() 将与当前线程关联的ThreadLocal值删除
            /*
            此句代码必须得加，非常重要，因为服务器分配的线程执行完毕后并没有被销毁，而是回到线程池(Tomcat服务器自带)中
            必须强制释放共享变量，才能保证只有一个session，以免保证SQL语句执行不紊乱
             */
        }
    }
}
