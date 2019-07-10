package com.kanghe.notes.pattern.proxy.custom;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @Author: W_jun1
 * @Date: 2019/7/10 20:28
 * @Description:
 **/
public class CustomProxy {

    public static Object newProxyInstance(CustomClassLoader classLoader, Class<?>[] interfaces, CustomInvocationHandler h) {
        try {
            // 1、动态生成源代码.java文件
            String src = generateSrc(interfaces);
            // 2、把Java文件输出到磁盘
            String filePath = CustomProxy.class.getResource("").getPath();
            System.out.println(filePath);
            File file = new File(filePath + "$Proxy0.java");
            FileWriter fw = new FileWriter(file);
            fw.write(src);
            fw.flush();
            fw.close();
            // 3、把生成的.java文件编译成.class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
            Iterable iterable = manager.getJavaFileObjects(file);
            JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, iterable);
            task.call();
            manager.close();
            // 4、把编译生成的.class文件加载到JVM中
            Class proxyClass = classLoader.findClass("$Proxy0");
            Constructor constructor = proxyClass.getConstructor(CustomInvocationHandler.class);
            file.delete();
            // 5、返回字节码重组以后的新的代理对象
            return constructor.newInstance(h);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String generateSrc(Class<?>[] interfaces) {
        StringBuffer sb = new StringBuffer();
        sb.append("package com.kanghe.notes.pattern.proxy.custom;" + "\r\n");
        sb.append("import java.lang.reflect.Method;" + "\r\n");
        sb.append("public class $Proxy0 implements " + interfaces[0].getName() + "{" + "\r\n");
        sb.append("CustomInvocationHandler h;" + "\r\n");
        sb.append("public $Proxy0(CustomInvocationHandler h) {" + "\r\n");
        sb.append("this.h = h;" + "\r\n");
        sb.append("}" + "\r\n");
        for (Method m : interfaces[0].getMethods()) {
            sb.append("public " + m.getReturnType().getName() + " " + m.getName() + "() {" + "\r\n");
            sb.append("try {" + "\r\n");
            sb.append("Method m = " + interfaces[0].getName() + ".class.getMethod(\"" + m.getName() + "\" ,new Class[]{});" + "\r\n");
            sb.append("this.h.invoke(this, m, null);" + "\r\n");
            sb.append("} catch (Exception e) {" + "\r\n");
            sb.append("e.printStackTrace();" + "\r\n");
            sb.append("}" + "\r\n");
            sb.append("}" + "\r\n");
        }
        sb.append("}" + "\r\n");
        return sb.toString();
    }

}
