## Package
A package is a collection of different classes. It helps in organizing classes and solving conflicts that may arise from having multiple classes with the same name.

### Benefits:
- **Prevents Conflicts**: Resolves the issue of having multiple classes with the same name by organizing them into packages.

### Importing Classes and Methods:

1. **Importing a Class from a Package**:
    - Use this when you want to import a specific class.
    - **Example**:
      ```java
      import OOPs.Class.Student;
      ```

2. **Importing a Method from a Class**:
    - For importing a static method, use the `static` keyword.
    - **Example**:
      ```java
      import static OOPs.Class.Student.getStudent;
      ```

3. **Importing Everything from a Package**:
    - Use the `*` to import all classes and methods from a package.
    - **Example**:
      ```java
      import static OOPs.Class.*;
      ```

# Java In-Built Packages

Java provides a set of standard libraries through in-built packages that simplify the development process. Below are some of the commonly used packages and their key classes or interfaces:

## 1. java.lang
The `java.lang` package contains fundamental classes and interfaces closely tied to the language itself, such as basic types, math operations, and exception handling.

- Key classes/interfaces: `String`, `Object`, `Math`, `Thread`, `Exception`, `Integer`, `Double`, `System`, `Runtime`, `Class`.

### Example:
```java
// Using String class from java.lang
public class Main {
    public static void main(String[] args) {
        String greeting = "Hello, World!";
        System.out.println(greeting.toUpperCase());  // Outputs: HELLO, WORLD!
    }
}
```

## 2. java.io
The java.io package contains classes for system input and output through data streams, serialization, and file handling.

- Key classes/interfaces: `File`, `FileReader`, `BufferedReader`, `InputStream`, `OutputStream`, `ObjectInputStream`, `ObjectOutputStream`, `Serializable`, `PrintWriter`, `IOException`.

### Example:
```java
// Reading from a file using java.io
import java.io.File;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        try {
            File file = new File("example.txt");
            FileReader reader = new FileReader(file);
            int data;
            while ((data = reader.read()) != -1) {
                System.out.print((char) data);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

## 3. java.util
The java.util package contains utility classes, such as data structures (List, Map, Set), date and time, and other helper functions.

- Key classes/interfaces: `ArrayList`, `LinkedList`, `HashMap`, `HashSet`, `Stack`, `Queue`, `Date`, `Collections`, `Iterator`, `Random`.

### Example:
```java
// Using ArrayList from java.util
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");
        System.out.println(list);  // Outputs: [Apple, Banana, Orange]
    }
}
```

## 4. java.applet
The java.applet package provides the Applet class, which allows for creating applets that can be embedded in web browsers. (Note: Applets are deprecated and no longer commonly used in modern development.)

- Key classes/interfaces: `Applet`, `AppletContext`, `AudioClip`.

### Example:
```java
// Simple Applet code
import java.applet.Applet;
import java.awt.Graphics;

public class HelloWorldApplet extends Applet {
    public void paint(Graphics g) {
        g.drawString("Hello, World!", 20, 20);
    }
}
```

## 5. java.awt
The java.awt package contains classes for creating user interfaces and drawing graphics, including components like buttons, text fields, and event-handling mechanisms.

- Key classes/interfaces: `Frame`, `Button`, `TextField`, `Label`, `Panel`, `Canvas`, `Graphics`, `Color`, `Event`, `Image`.

### Example:
```java
// Creating a simple Frame using java.awt
import java.awt.Frame;

public class Main {
    public static void main(String[] args) {
        Frame frame = new Frame("My First AWT Frame");
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}
```

## 6. java.net
The java.net package contains classes for networking, including support for URLs, sockets, and IP addresses.

- Key classes/interfaces: `URL`, `URLConnection`, `Socket`, `ServerSocket`, `InetAddress`, `HttpURLConnection`, `DatagramSocket`, `MulticastSocket`, `URI`, `CookieManager`.

### Example:
```java
// Using java.net to open a URL connection
import java.net.URL;
import java.net.URLConnection;

public class Main {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://youtube.com");
            URLConnection conn = url.openConnection();
            System.out.println("Content Type: " + conn.getContentType());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

### Access Modifiers
Access modifiers control the visibility of classes, methods, and other members. Here’s a summary table:

| Access Modifier | Class | Package | Subclass (same pkg) | Subclass (diff pkg) | World |
|-----------------|-------|--------|--------------------|---------------------|-------|
| **public**      | +     | +      | +                  | +                   | +     |
| **protected**   | +     | +      | +                  | +                   |       |
| **default**     | +     | +      | +                  |                     |       |
| **private**     | +     |        |                    |                     |       |

### Notes:
- **public**: Members declared as public are accessible from any other class in any package.
- **protected**: Members declared as protected are accessible within the same package and by subclasses.
- **private**: Members declared as private are only accessible within the class they are declared.
- **default**: Members with no modifier (default) are accessible only within the same package.
