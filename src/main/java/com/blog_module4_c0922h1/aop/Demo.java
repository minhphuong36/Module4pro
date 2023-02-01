package com.blog_module4_c0922h1.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Demo {
    @Before("within(com.blog_module4_c0922h1.service.BlogService)")
    public void demo(){
        System.out.println("-------------------");
        System.out.println("-------------------");
        System.out.println("Đã chạy vào đây");
        System.out.println("-------------------");
        System.out.println("-------------------");
    }

}
