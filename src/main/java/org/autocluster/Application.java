package org.autocluster;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Application
{

    public static void main(String[] args)
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        BorderInterface lib = context.getBean(BorderInterface.class);

        System.out.println(lib.execute());
    }
}
