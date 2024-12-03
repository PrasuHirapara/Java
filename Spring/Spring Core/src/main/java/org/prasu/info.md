# Introduction
Spring is an open-source application framework for Java. It provides comprehensive infrastructure support for developing Java applications, making it easier to write clean, maintainable, and scalable code.

## Why Use Spring?
- Simplifies the development process by promoting best practices.
- Provides a lightweight container for dependency injection.
- Highly modular and supports a wide range of functionalities through its modules.
- Enhances application security, scalability, and performance.

## Advantages of Spring
1. **Lightweight and Flexible**: Can be used for various types of Java applications.
2. **Dependency Injection**: Facilitates loose coupling between components.
3. **Powerful AOP**: Aspect-Oriented Programming is seamlessly integrated.
4. **Comprehensive Support**: For database access, messaging, transaction management, and more.
5. **Wide Adoption**: Large community and extensive documentation.

## Spring Architecture

![Spring Architecture](https://www.tutorialspoint.com/spring/images/spring_architecture.png)

### Layers of Spring Architecture:
1. **Presentation Layer**: Implements web-based functionalities using Spring MVC.
2. **Service Layer**: Business logic is implemented here using service classes.
3. **Repository Layer**: Handles database interactions.
4. **Integration Layer**: Manages interactions with external systems.
5. **Core Container**: Provides foundational support for Dependency Injection and POJO-based development.

## Key Spring Concepts

### POJO Model
Spring promotes the use of Plain Old Java Objects (POJOs), enabling developers to write clean and testable code.

### Services
Services encapsulate the business logic of an application. They act as an intermediary between controllers and repositories.

## Popular Spring Modules

### Dependencies with Maven Types:

1. **Spring Core**:
    - **Maven Project Type**: Archetype
   ```xml
   <dependency>
       <groupId>org.springframework</groupId>
       <artifactId>spring-core</artifactId>
   </dependency>
   ```

2. **Spring Context**:
    - **Maven Project Type**: Application Framework
    - **Details**: The `spring-context` module extends `spring-core` by providing advanced features like `ApplicationContext`, event handling, and internationalization. It builds upon the core functionalities to support more complex applications.
   ```xml
   <dependency>
       <groupId>org.springframework</groupId>
       <artifactId>spring-context</artifactId>
   </dependency>
   ```

3. **Spring MVC**:
    - **Maven Project Type**: Web Framework
   ```xml
   <dependency>
       <groupId>org.springframework</groupId>
       <artifactId>spring-webmvc</artifactId>
   </dependency>
   ```

4. **Spring REST**:
    - **Maven Project Type**: Web Service
   ```xml
   <dependency>
       <groupId>org.springframework</groupId>
       <artifactId>spring-web</artifactId>
   </dependency>
   ```

5. **Spring Security**:
    - **Maven Project Type**: Security Framework
   ```xml
   <dependency>
       <groupId>org.springframework</groupId>
       <artifactId>spring-security-core</artifactId>
   </dependency>
   ```

6. **Spring Data**:
    - **Maven Project Type**: Database Access
   ```xml
   <dependency>
       <groupId>org.springframework.data</groupId>
       <artifactId>spring-data-jpa</artifactId>
   </dependency>
   ```

7. **Spring AOP**:
    - **Maven Project Type**: Aspect-Oriented Programming
   ```xml
   <dependency>
       <groupId>org.springframework</groupId>
       <artifactId>spring-aop</artifactId>
   </dependency>
   ```

8. **Spring Web**:
    - **Maven Project Type**: Web Application
   ```xml
   <dependency>
       <groupId>org.springframework</groupId>
       <artifactId>spring-web</artifactId>
   </dependency>
   ```

## Spring MVC to Tomcat to Servlet Workflow
1. The client sends an HTTP request.
2. The request is routed via the DispatcherServlet.
3. The DispatcherServlet interacts with controllers.
4. Responses are generated and sent back to the client.

---