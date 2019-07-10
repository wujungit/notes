package com.kanghe.notes.pattern.proxy.jdk;

/**
 * @Author: W_jun1
 * @Date: 2019/7/8 20:50
 * @Description: 字节码重组：
 * 1、拿到被代理对象的引用，并且通过反射获取它所有的接口；
 * 2、JDK Proxy类重新生成一个新的类，并且实现被代理类实现的所有的接口；
 * 3、动态生成Java代码，把新加的业务逻辑方法由一定的逻辑代码去调用（在代码中体现）
 * 4、编译新生成的Java代码.class
 * 5、再重新加载到JVM中运行
 **/
public class JdkProxyTest {

    public static void main(String[] args) {
        Person instance = (Person) new JdkProxy().getInstance(new XiaoMing());
        instance.moveBrick();
        instance.makeMoney();
    }

}
