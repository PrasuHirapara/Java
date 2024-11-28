# Dependency Management in Multi-Module Projects

Multi-module projects organize related modules into a single project. Dependency management in such setups ensures consistency and reduces redundancy.

### 1. Parent POM
The parent POM is the central place to define common configurations and dependency management.

#### Example
```xml
<project>
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.example</groupId>
    <artifactId>parent-project</artifactId>
    <version>1.0.0</version>
    <packaging>pom</packaging>
    
    <modules>
        <module>module-a</module>
        <module>module-b</module>
    </modules>
    
    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-web</artifactId>
                <version>2.5.4</version>
            </dependency>
        </dependencies>
    </dependencyManagement>
</project>
```

### 2. Child Modules
Child modules inherit dependencies and configurations from the parent POM.

#### Example: `module-a/pom.xml`
```xml
<project>
    <parent>
        <groupId>com.example</groupId>
        <artifactId>parent-project</artifactId>
        <version>1.0.0</version>
    </parent>
    <artifactId>module-a</artifactId>
    
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
    </dependencies>
</project>
```

### 3. Dependency Mediation
Maven resolves version conflicts using dependency mediation, where the nearest dependency to the project in the dependency tree takes precedence.

#### Example: Conflict Resolution
If module A uses version 1.0 of a library and module B uses version 2.0, the parent POM or dependency tree determines which version is included.

### 4. Best Practices
- Use `dependencyManagement` in the parent POM for consistent dependency versions.
- Avoid specifying versions in child modules.
- Use exclusions to remove unnecessary dependencies.
- Run `mvn dependency:tree` to analyze and debug dependency conflicts.

---

## Conclusion
Maven’s robust dependency management system simplifies handling dependencies in single and multi-module projects. Following best practices ensures efficient and conflict-free builds.
