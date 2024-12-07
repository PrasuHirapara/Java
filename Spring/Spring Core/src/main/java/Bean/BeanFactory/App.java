package Bean.BeanFactory;

import IoC.Doctor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("Beans.xml");

        System.out.println(beanFactory.containsBean("doctor"));
        System.out.println(beanFactory.isSingleton("doctor"));

        Doctor staff = (Doctor) beanFactory.getBean("doctor");
        staff.assist();
        System.out.println(staff.getName());
        System.out.println(staff.getQualification());
    }
}
