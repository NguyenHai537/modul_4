package xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("configBeans.xml");

        Developer de = (Developer) context.getBean("frontend");
        System.out.println(de);

        Developer be = (Developer) context.getBean("backend");
        System.out.println(be);
    }

}
