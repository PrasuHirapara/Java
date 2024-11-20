# Maven Dependency Management
- In Maven, a dependency is a Java library or module required by your project. Maven simplifies dependency management by automatically downloading the required libraries, including their transitive dependencies, from remote repositories and storing them locally for reuse.
- **Dependencies in Maven** specify external JAR files or libraries needed for the project to compile and run.
- Defined in the `pom.xml` file under the `<dependencies>` section.
- Dependency management includes resolving transitive dependencies (dependencies of dependencies) and avoiding conflicts between versions.

### Adding a Dependency

Dependencies are added to the Maven `pom.xml` file. For example:

```xml
<dependencies>
    <dependency>
        <groupId>org.apache.commons</groupId>
        <artifactId>commons-lang3</artifactId>
        <version>3.12.0</version>
    </dependency>
</dependencies>
```

Here:

- `groupId`: Identifies the organization or group publishing the library.
- `artifactId`: Identifies the library.
- `version`: Specifies the version of the library.

### Dependency Scope

Maven allows you to define the scope of a dependency, determining its visibility during different phases of the build process. Common scopes include:

- `compile`: Default scope; available during compile and runtime.
- `provided`: Available during compile but not packaged with the application.
- `runtime`: Available during runtime but not compile.
- `test`: Only available during testing.

### Dependency Management

#### Steps to Manage Dependencies

1. **Define Dependencies in `pom.xml`**: Add dependencies under the `<dependencies>` section.

2. **Check Transitive Dependencies**: Run `mvn dependency:tree` to view the dependency hierarchy.

3. **Exclude Unwanted Transitive Dependencies**: Use `<exclusions>` in your dependency declaration:

```xml
<dependency>
    <groupId>org.apache.hadoop</groupId>
    <artifactId>hadoop-common</artifactId>
    <version>3.3.1</version>
    <exclusions>
        <exclusion>
            <groupId>javax.servlet</groupId>
            <artifactId>servlet-api</artifactId>
        </exclusion>
    </exclusions>
</dependency>
```

#### Resolve Version Conflicts

Use `<dependencyManagement>` to define a single version for transitive dependencies:

```xml
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-api</artifactId>
            <version>1.7.32</version>
        </dependency>
    </dependencies>
</dependencyManagement>
```

### Resolving Dependencies

- **Check the Local Repository**: Maven first checks the local repository (~/.m2/repository) for the required dependency. If the dependency is found locally, it is used.

- **Search Remote Repositories**: If the dependency is not found locally, Maven searches in the remote repositories. By default, it queries:
    - Maven Central Repository: The default central repository for Maven artifacts.
    - Custom Repositories: Additional repositories defined in the pom.xml or settings.xml.

- **Download and Cache**: If the dependency is found in a remote repository, Maven downloads it and stores it in the local repository for future use.

### Storing Dependencies Locally

Maven stores downloaded dependencies in the `.m2` directory (default location: ~/.m2/repository).  
You can change the local repository location in the settings.xml file:

```xml
<settings>
    <localRepository>/path/to/local/repository</localRepository>
</settings>
```
### Resolving Dependency Issues

- **Force Update Dependencies**: Run `mvn clean install -U` to update dependencies from the remote repository.

- **Manually Install a Dependency in Local Repository**: Use the `install:install-file` goal:

mvn install:install-file -Dfile=path-to-jar -DgroupId=com.example \
-DartifactId=example-artifact -Dversion=1.0 -Dpackaging=jar

- **Check for Conflicts**: Use the `mvn dependency:analyze` command to identify unnecessary or missing dependencies.

## Conclusion

Maven dependency management automates the process of resolving, downloading, and storing dependencies, ensuring a smooth build process. Understanding scopes, transitive dependencies, and conflict resolution techniques is essential for efficient project management.
