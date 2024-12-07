package Bean.ApplicationContext;


import IoC.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        Doctor staff = (Doctor) context.getBean("doctor");
        staff.assist();
        System.out.println(staff.getName());
        System.out.println(staff.getQualification());
    }
}
