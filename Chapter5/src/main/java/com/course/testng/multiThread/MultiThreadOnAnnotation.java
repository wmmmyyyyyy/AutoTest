package com.course.testng.multiThread;

import org.testng.annotations.Test;

public class MultiThreadOnAnnotation {
    @Test(invocationCount = 10,threadPoolSize = 3)
    public void test(){
        System.out.printf("Thread id:%s%n",Thread.currentThread().getId());
    }
}
