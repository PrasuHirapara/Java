# Beans

## Introduction
In the Spring Framework, a **Bean** is an object that is instantiated, assembled, and managed by the Spring IoC container.
Beans form the backbone of any Spring-based application and represent the application objects.

### What is a Bean?
A bean is a Java object managed by the Spring container. Beans are created, configured, and managed within the container and are defined in Spring configuration files (XML, Java-based, or annotations).

### Bean Scope
- Using `@Scope(scopeName = "")` annotation.
1. **Singleton** (Default): Only one instance of the bean is created per Spring container.
2. **Prototype**: A new instance is created every time the bean is requested.
3. **Request**: One instance per HTTP request (used in web applications).
4. **Session**: One instance per HTTP session (used in web applications).
5. **Global Session**: Scoped to a global HTTP session.

- Example
```xml
    <bean id="nurse" class="IoC.Nurse" scope="prototype" />
```
```java
package IoC;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName = "prototype")
public class Nurse implements Staff{

    @Override
    public void assist() {
        System.out.println("Nurse is assisting");
    }
}
``` 

### Bean Lifecycle
The lifecycle of a bean in Spring involves several phases, from creation to destruction. Below is an overview of the lifecycle:
1. Instantiate: The container creates the bean instance.
2. Populate Properties: The container injects dependencies into the bean.
3. BeanNameAware and BeanFactoryAware: The bean can interact with the container by implementing these interfaces.
4. Pre-initialization: BeanPostProcessor’s `postProcessBeforeInitialization()` is called.
5. Initialize: The bean’s custom initialization method is invoked.
6. Post-initialization: BeanPostProcessor’s `postProcessAfterInitialization()` is called.
7. Ready to Use: The bean is ready for use by the application.
8. Destruction: The container calls the bean’s custom destroy method when the context is closed.

### Common methods(in both `ApplicatoinContext` and `BeanFactory`)
## Important Spring `Bean` Methods

- #### `containsBean(String name)`
Checks if the bean with the specified name is present in the application context.

- #### `getBean(String name)`
Returns the bean instance registered with the specified name.

- #### `getBean(Class<T> requiredType)`
Returns the bean instance of the specified type.

- #### `getBeanDefinitionNames()`
Returns the names of all the bean definitions present in the application context.

- #### `getType(String name)`
Returns the type of the bean with the specified name.

- #### `isSingleton(String name)`
Determines whether the bean with the specified name is a singleton.

### Configuration Methods
Beans can be configured in Spring using:
1. **XML Configuration**: Define beans in an XML file, specifying their ID, class, and dependencies.
- Example:
```java
package IoC;

public class Doctor implements Staff{
private String qualification;
private String name;

    Doctor(Nurse nurse) {
        nurse.assist();
    }

    @Override
    public void assist() {
        System.out.println("Doctor is assisting");
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
                           http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd">

       <bean id="doctor" class="IoC.Doctor">
           <property name="qualification" value="Developer" />
           <property name="name" value="Prasu" />
           <constructor-arg name="nurse" ref="nurse" />
       </bean>
       <bean id="nurse" class="IoC.Nurse"></bean>

</beans>

```

2. **Java Configuration**: Use `@Configuration` and `@Bean` annotations to define beans.
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
```java
package IoC;

import org.springframework.stereotype.Component;

public class Doctor implements Staff{
    private String qualification;
    private String name;
    
    public Doctor(Nurse nurse) {
        nurse.assist();
    }

    @Override
    public void assist() {
        System.out.println("Doctor is assisting");
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

3. **Annotations**: Use annotations like `@Component`, `@Service`, `@Repository`, and `@Controller` to define beans.
- Example:
```java
package IoC;

import org.springframework.stereotype.Component;

@Component
public class Doctor implements Staff{
    private String qualification;
    private String name;
    
    Doctor(Nurse nurse) {
        nurse.assist();
    }

    @Override
    public void assist() {
        System.out.println("Doctor is assisting");
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
                           http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd">
   
    <context:component-scan base-package="IoC"/>

</beans>

```

#### Explanation of Common Annotations
1. **@Component**: A generic stereotype for any Spring-managed component. Used on classes.
2. **@Service**: A specialization of `@Component` for service layer logic. Used on classes.
3. **@Repository**: A specialization of `@Component` for the data access layer. Used on classes.
4. **@Controller**: A specialization of `@Component` for Spring MVC controllers. Used on classes.

These annotations can only be applied to **classes**, not variables or methods, as they define the role of a class within the application.

### Bean PostProcessor
**BeanPostProcessor** is an interface provided by Spring to intercept the initialization process of beans. It allows developers to add custom logic during the pre- and post-initialization phases of bean creation.

1. **`postProcessBeforeInitialization`**: This method is called before a bean’s initialization methods are executed.
2. **`postProcessAfterInitialization`**: This method is called after a bean’s initialization methods are executed.

### Dependency Injection (DI)
1. **Field Injection**: Inject dependencies directly into fields using `@Autowired`.
2. **Constructor Injection**: Pass dependencies through the constructor (recommended for mandatory dependencies).
3. **Setter Injection**: Use setter methods to inject optional dependencies.

### Bean Validation
Spring provides support for validating bean properties using the Java Bean Validation API (e.g., `@NotNull`, `@Size`, `@Min`, etc.).

### Factory Beans
1. Factory beans are special beans that act as factories to produce other beans.
2. Declared in the configuration file and implemented using `FactoryBean` interface.

### BeanFactory vs ApplicationContext

| Feature                 | BeanFactory                         | ApplicationContext                   |
|-------------------------|--------------------------------------|---------------------------------------|
| **Lazy Initialization** | Yes                                 | No (eager by default)                 |
| **Advanced Features**   | No                                  | Yes (AOP, Event Handling, i18n, etc.) |
| **Event Handling**      | No                                  | Yes                                   |
| **Usage**               | Lightweight applications            | Enterprise-level applications         |
| **Resource Management** | Basic                               | Advanced                              |
| **Recommended**         | Simple applications or unit tests   | Complex or enterprise-level projects  |

## Steps to Configure Beans

1. **Add Spring Dependency**: Include Spring dependencies in your project (e.g., Maven or Gradle).
2. **Create a Configuration**:
    - For XML: Define the bean in `/main/resources/Bean.xml`.
    - For Java: Use a configuration class with `@Configuration` and `@Bean`.
    - For Annotations: Annotate the bean class with `@Component`.
3. **Initialize Container**: Load the configuration into the IoC container.
4. **Access Beans**: Retrieve the bean using the `getBean()` method.

## Bean Lifecycle Diagram
Below is a link to the Bean Lifecycle diagram that visually explains the stages a bean undergoes during its lifecycle:

[View Bean Lifecycle Diagram](https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcToUlOAQ-_NEryTHrg3x4_dwB8mHCieXUlxRw&s)

## Advantages of Beans in Spring

1. **Loose Coupling**: Encourages loosely coupled application development through DI.
2. **Reusable Components**: Beans can be reused across different parts of the application.
3. **Lifecycle Management**: The Spring container manages the complete lifecycle of beans.

## Limitations of Beans in Spring

1. **Complexity**: For simple applications, defining and managing beans can be overkill.
2. **Learning Curve**: Requires knowledge of Spring's DI and IoC concepts.
3. **Performance**: Large applications with a significant number of beans may see increased startup time.

## Conclusion
Beans are the foundation of the Spring Framework's IoC container. Proper understanding of their lifecycle, configuration, and scope is critical for building robust Spring applications.
