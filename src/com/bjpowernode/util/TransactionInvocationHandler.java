package com.bjpowernode.util;

import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TransactionInvocationHandler implements InvocationHandler {

    // 这就相当于张三
    private Object target;

    public TransactionInvocationHandler(Object target) {
        this.target = target;
    }

    // 李四的表白方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        SqlSession session = null;
        Object obj = null;

        try {
            session = SqlSessionUtil.getSession();
            obj = method.invoke(target,args);    // 处理业务逻辑，method.invoke 张三的表白方法
            session.commit();            // 处理业务逻辑完毕后，提交事务
        }catch (Exception e){
            session.rollback();
            e.printStackTrace();
        }finally {
            SqlSessionUtil.myClose(session);
        }

        return obj;
    }

    // 取得李四对象必须由这句话得到
    public Object getProxy(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),this);
    }


}
