package com.howie.util;

import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TransactionInvocationHandler implements InvocationHandler {
    private Object target; // 目标对象(明星)即被代理类

    public TransactionInvocationHandler(Object target) {
        this.target = target;
    }
    // 代理类的业务方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        SqlSession session = null;
        Object obj = null;
        try{
            session = SqlSessionUtil.getSession();
            // 处理业务逻辑
            obj = method.invoke(target,args); // 被代理类的方法
            // 处理业务逻辑完毕后，提交事务
            session.commit();
        } catch(Exception e){
            if(session != null){
                session.rollback();
            }
            e.printStackTrace();
        } finally{
            SqlSessionUtil.closeSession(session);
        }
        return obj;
    }
    // 取得代理类对象(经济人)，只能由此方法取得
    public Object getProxy(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }
}