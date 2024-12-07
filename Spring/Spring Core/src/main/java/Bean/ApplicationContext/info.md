# ApplicationContext

## Introduction
ApplicationContext is a central interface in the Spring Framework, responsible for providing configuration information
to the Spring application. It extends the BeanFactory interface and offers additional features such as AOP integration,
message resource handling, and event propagation, making it a po<constructor-arg ref=""/>e container for managing Spring beans.

## Features of ApplicationContext

1. **Bean Lifecycle Management**: Automatically handles the creation, initialization, and destruction of beans.
2. **Dependency Injection**: Supports both constructor-based and setter-based dependency injection.
3. **Internationalization**: Provides support for internationalization (i18n) through the `MessageSource` interface.
4. **Event Propagation**: Supports event handling and propagation via the `ApplicationEvent` and `ApplicationListener` classes.
5. **AOP Integration**: Integrates seamlessly with Aspect-Oriented Programming (AOP) to provide cross-cutting concerns.
6. **Resource Loading**: Provides a consistent way to load resources such as files and URLs.
7. **Automatic Bean Post-processing**: Manages and applies bean post-processors to beans automatically.

## Working of ApplicationContext

1. **Configuration**: The ApplicationContext is configured using XML, Java-based configuration, or annotations.
2. **Initialization**: During initialization, the context reads the configuration and instantiates beans as needed.
3. **Bean Factory**: It acts as a factory for Spring beans and manages their lifecycle and dependencies.
4. **Event Handling**: Developers can register event listeners to respond to application-specific events.
5. **Resource Management**: The context loads resources like properties files and makes them available to the application.

## Steps to Use ApplicationContext in a Spring Application

1. **Add Spring Dependency**: Include Spring Framework dependencies in your project (e.g., via Maven or Gradle).
2. **Create Configuration**: Define the application configuration using XML, Java classes, or annotations.
3. **Initialize ApplicationContext**: Instantiate `ApplicationContext` using one of its implementations, such as:
    - `ClassPathXmlApplicationContext`: Add Beans.xml file in `main/resources` folder.

- ## Example
```java
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


```
   - `FileSystemXmlApplicationContext`
   - `AnnotationConfigApplicationContext`
```java
package Bean.ApplicationContext;


import Bean.JavaConfig.JavaConfig;
import IoC.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);

        Doctor staff = (Doctor) context.getBean("doctor");
        staff.assist();
        System.out.println(staff.getName());
        System.out.println(staff.getQualification());
    }
}
```
```java
package Bean.JavaConfig;

import IoC.Doctor;
import IoC.Nurse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = "IoC") // if not, then define Bean yourself using @Bean annotation
public class JavaConfig {

    @Bean
    public Nurse nurse() {
        return new Nurse();
    }

    @Bean
    public Doctor doctor() {
        return new Doctor(nurse());
    }
}
```

4. **Access Beans**: Use `getBean()` to retrieve and use beans defined in the configuration.
5. **Register Listeners (Optional)**: Add custom event listeners if event handling is required.
6. **Close Context (Optional)**: Explicitly close the context if resources need to be released manually.


## Advantages of ApplicationContext

1. **Advanced Features**: Offers more advanced features than `BeanFactory`, such as event propagation and AOP support.
2. **Ease of Use**: Simplifies application development by managing beans and their dependencies.
3. **Internationalization**: Built-in support for message localization.
4. **Event Handling**: Allows developers to build event-driven applications.
5. **Integration with Spring Ecosystem**: Easily integrates with other Spring modules like Spring Security, Spring AOP, and Spring Data.

## Limitations of ApplicationContext

1. **Memory Usage**: May consume more memory compared to `BeanFactory` due to advanced features.
2. **Startup Time**: Takes longer to initialize because it pre-instantiates singleton beans.
3. **Complexity**: For small applications, it may introduce unnecessary complexity.
4. **Dependency on Spring**: Tightly coupled with the Spring Framework, making it less portable.

## Conclusion

ApplicationContext is a robust and feature-rich container in the Spring Framework, ideal for enterprise-level applications.
While it has some limitations, its advantages outweigh them, making it a popular choice for managing application components and resources.
