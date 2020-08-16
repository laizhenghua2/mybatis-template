package com.howie.util;

public class ServiceFactory {
    // 传递被代理对象(明星)，得到代理对象(经济人)
    public static Object getService(Object service){
        return new TransactionInvocationHandler(service).getProxy();
    }
}
