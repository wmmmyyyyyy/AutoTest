package com.course.testng.suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class SuiteConfig {

    @BeforeSuite
    public void beforeSuit(){
        System.out.print("before suit运行啦");
    }

    @AfterSuite
    public void afterSuit(){
        System.out.print("after suit运行啦");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("beforeTest");
    }

    @AfterTest
    public void atferTest(){
        System.out.println("afterTest");
    }
}
