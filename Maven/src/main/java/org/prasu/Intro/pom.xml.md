# **pom.xml Introduction**
The `pom.xml` (Project Object Model) is the heart of a Maven project. It manages project dependencies, plugins, goals, and settings.

## **Basic Structure**

```xml
<project>
  <modelVersion>4.0.0</modelVersion> <!-- Model version -->
  <groupId>com.example</groupId> <!-- Organization or project ID -->
  <artifactId>my-app</artifactId> <!-- Application name -->
  <version>1.0-SNAPSHOT</version> <!-- Application version -->
</project>
```

## **Essential Tags with Examples**

1. `<modelVersion>`  
   Example:  
   ```xml
   <modelVersion>4.0.0</modelVersion>
   ```

2. `<groupId>`  
   Example:  
   ```xml
   <groupId>com.example</groupId>
   ```

3. `<artifactId>`  
   Example:  
   ```xml
   <artifactId>my-app</artifactId>
   ```

4. `<version>`  
   Example:  
   ```xml
   <version>1.0-SNAPSHOT</version>
   ```

5. `<packaging>`  
   Example:  
   ```xml
   <packaging>jar</packaging>
   ```

6. `<dependencies>`  
   Example:  
   ```xml
   <dependencies>
     <dependency>
       <groupId>org.springframework</groupId>
       <artifactId>spring-core</artifactId>
       <version>5.3.10</version>
       <scope>compile</scope>
     </dependency>
   </dependencies>
   ```

7. `<repositories>`  
   Example:  
   ```xml
   <repositories>
     <repository>
       <id>central</id>
       <url>https://repo.maven.apache.org/maven2</url>
     </repository>
   </repositories>
   ```

8. `<pluginRepositories>`  
   Example:  
   ```xml
   <pluginRepositories>
     <pluginRepository>
       <id>apache-snapshots</id>
       <url>https://repository.apache.org/snapshots</url>
     </pluginRepository>
   </pluginRepositories>
   ```

9. `<build>`  
   Example:  
   ```xml
   <build>
     <plugins>
       <plugin>
         <groupId>org.apache.maven.plugins</groupId>
         <artifactId>maven-compiler-plugin</artifactId>
         <version>3.8.1</version>
         <configuration>
           <source>11</source>
           <target>11</target>
         </configuration>
       </plugin>
     </plugins>
   </build>
   ```

10. `<profiles>`  
    Example:  
    ```xml
    <profiles>
      <profile>
        <id>dev</id>
        <activation>
          <activeByDefault>true</activeByDefault>
        </activation>
        <properties>
          <env>development</env>
        </properties>
      </profile>
    </profiles>
    ```
    
## **Common Scopes for Dependencies (Detailed)**

1. **compile**  
   - **Description**: This is the default scope if no other scope is specified. Dependencies with this scope are required for both compiling and running the application.  
   - **Example**:  
     ```xml
     <dependency>
       <groupId>org.apache.commons</groupId>
       <artifactId>commons-lang3</artifactId>
       <version>3.12.0</version>
       <scope>compile</scope>
     </dependency>
     ```

2. **provided**  
   - **Description**: Dependencies are required for compilation but are provided by the JDK or the application server at runtime.  
   - **Example**:  
     ```xml
     <dependency>
       <groupId>javax.servlet</groupId>
       <artifactId>javax.servlet-api</artifactId>
       <version>4.0.1</version>
       <scope>provided</scope>
     </dependency>
     ```

3. **runtime**  
   - **Description**: Dependencies are required during runtime but not for compilation.  
   - **Example**:  
     ```xml
     <dependency>
       <groupId>mysql</groupId>
       <artifactId>mysql-connector-java</artifactId>
       <version>8.0.29</version>
       <scope>runtime</scope>
     </dependency>
     ```

4. **test**  
   - **Description**: Dependencies are only required during the testing phase. They are not included in the final artifact.  
   - **Example**:  
     ```xml
     <dependency>
       <groupId>junit</groupId>
       <artifactId>junit</artifactId>
       <version>4.13.2</version>
       <scope>test</scope>
     </dependency>
     ```
     
---