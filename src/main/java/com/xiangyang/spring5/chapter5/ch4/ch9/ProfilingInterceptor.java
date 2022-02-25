package com.xiangyang.spring5.chapter5.ch4.ch9;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

import java.lang.reflect.Method;

/**
 * @Author yixiangyang
 * @Date 2022/2/25 15:31
 */
public class ProfilingInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        StopWatch sw = new StopWatch();
        sw.start(invocation.getMethod().getName());
        Object returnValue = invocation.proceed();
        sw.stop();
        dumpInfo(invocation,sw.getTotalTimeMillis());
        return returnValue;
    }

    public void dumpInfo(MethodInvocation invocation,long ms){
        Method m = invocation.getMethod();
        Object target = invocation.getThis();
        System.out.println("target invocation.getThis::"+target);
        Object[] args = invocation.getArguments();
        System.out.println("Executed method:"+ m.getName());
        System.out.println("On object of type"+ target.getClass().getName());
        System.out.println("with arguments:");
        for (int x = 0;x< args.length;x++){
            System.out.print(">" + args[x]);
        }
        System.out.println("");
        System.out.println("Took:"+ms +"  ms");
    }
}
