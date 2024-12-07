# BeanFactory
BeanFactory is the foundational interface in the Spring Framework for managing the lifecycle of beans.
It provides the basic functionalities for bean instantiation, configuration, and lifecycle management.
While it is lightweight and suitable for simple applications, it lacks some advanced features offered by ApplicationContext.

## Example
```java
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
```

## Features of BeanFactory

1. **Lazy Initialization**: Beans are created only when they are requested for the first time.
2. **Dependency Injection**: Supports both setter-based and constructor-based dependency injection.
3. **Lightweight**: Suitable for applications where resource usage is a primary concern.
4. **Customizable**: Allows bean post-processing and custom initialization/destruction methods.

## Working of BeanFactory

1. **Configuration**: Beans are configured using XML or annotations.
2. **Initialization**: The `BeanFactory` reads the configuration and prepares the context.
3. **Lazy Loading**: Beans are instantiated only when `getBean()` is called.
4. **Dependency Management**: Manages dependencies and ensures the required beans are injected properly.

## Steps to Use BeanFactory in a Spring Application

1. **Add Spring Dependency**: Include Spring Framework dependencies in your project (e.g., via Maven or Gradle).
2. **Create Configuration**: Define bean configurations in an XML file (e.g., `beans.xml`).
3. **Initialize BeanFactory**: Instantiate `BeanFactory` using an implementation like `XmlBeanFactory` (deprecated) or newer alternatives.
4. **Access Beans**: Use `getBean()` to retrieve and use the defined beans.

## Advantages of BeanFactory

1. **Lightweight**: Consumes minimal resources, making it ideal for small applications.
2. **Lazy Initialization**: Beans are created only when needed, saving memory and CPU resources.
3. **Simple**: Easy to understand and implement for basic use cases.

## Limitations of BeanFactory

1. **Lacks Advanced Features**: Does not support AOP, event propagation, or internationalization.
2. **Manual Initialization**: Requires manual configuration and initialization of beans.
3. **Deprecated Implementations**: Many `BeanFactory` implementations like `XmlBeanFactory` are deprecated in favor of `ApplicationContext`.
4. **No Built-in Event Handling**: Lacks support for event-driven programming.

## Conclusion

BeanFactory is a lightweight and efficient container suitable for simple use cases.
However, for enterprise-level applications or advanced features like AOP, event handling, and internationalization,
ApplicationContext is recommended.
