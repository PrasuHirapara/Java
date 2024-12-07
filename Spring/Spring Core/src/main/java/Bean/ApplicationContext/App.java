package Bean.ApplicationContext;


import Bean.JavaConfig.JavaConfig;
import IoC.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
//        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);

        Doctor staff = (Doctor) context.getBean("doctor");
        staff.assist();
        System.out.println(staff.getName());
        System.out.println(staff.getQualification());

    }
}
