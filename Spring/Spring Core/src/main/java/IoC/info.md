# IoC (Inversion of Control)
- **Definition:** IoC is a design principle where the framework controls the flow of a program and the creation and management of objects.

## Why Use IoC?

- Reduces coupling between components.
- Increases flexibility and maintainability.
- Simplifies unit testing.

## Dependency Injection

Dependency Injection (DI) is the most common implementation of IoC. It allows the Spring container to inject dependencies into objects.

## Types of Dependency Injection

1. **Constructor Injection**
```xml
<bean id="doctor" class="IoC.Doctor">
    <constructor-arg name="nurse" ref="nurse" />
</bean>
```
2. **Setter Injection**
```xml
<bean id="doctor" class="IoC.Doctor">
    <property name="qualification" value="Developer" />
</bean>
```
3. **Field Injection**
```xml
<bean id="doctor" class="IoC.Doctor">
    <property name="name" value="Prasu" />
</bean>
```

## Spring IoC Container

The Spring IoC Container is responsible for creating and managing beans. There are two main types of containers:

1. **BeanFactory:** Basic container for managing beans.
2. **ApplicationContext:** Advanced container providing additional features.

## Advanced IoC Features

- **Profiles:** Conditional bean definitions for different environments.
- **Lazy Initialization:** Delay bean creation until needed.
- **Bean Post Processors:** Customize bean initialization.

## Advantages of IoC

- **Loose Coupling:** Decouples components.
- **Easier Testing:** Simplifies unit testing with mock objects.
- **Flexible Configuration:** XML, annotations, or Java-based.

## Disadvantages of IoC

- **Learning Curve:** Steeper learning curve for beginners.
- **Performance Overhead:** Slight performance cost for bean management.
- **Complex Configuration:** Large projects may require complex configurations.

## Conclusion

Spring IoC is a powerful concept that promotes flexible and maintainable application development by decoupling object creation and management from business logic.

---