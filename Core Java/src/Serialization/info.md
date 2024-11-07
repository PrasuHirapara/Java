# Serialization
Serialization in Java is the process of converting an object into a byte stream to save it to a file or send it over a network. Deserialization is the reverse process where the byte stream is converted back into a copy of the original object.
Serialization is useful when you want to persist the state of an object, such as saving the object data to a file or transferring it between different parts of a distributed system.

## Advantages
1. **Persistence**: Objects can be saved to a storage medium and restored later.
2. **Network Communication**: Allows objects to be sent over a network.
3. **Caching**: Allows object data to be saved temporarily and retrieved faster.

## Rules for Serialization
1. **Implement `Serializable` Interface**: The class must implement the `java.io.Serializable` interface.
2. **Mark Transient Fields**: Mark fields that should not be serialized with the `transient` keyword.
3. **Static Fields Are Not Serialized**: Static fields belong to the class, not individual instances, so they are not serialized.
4. **Serializable Hierarchy**: If a superclass is not serializable, only the serializable subclass fields are saved.
5. **Custom Serialization**: Implement `writeObject` and `readObject` methods for custom serialization logic.

## Example Code

### User Class
This class implements `Serializable`, which allows it to be converted into a byte stream for serialization.

```java
package Serialization;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String password;
    private static int total = 0;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
        total++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", password=" + password + ", total=" + total + "]";
    }
}
```

### Serialization Code
The `Serialize` class demonstrates saving a `User` object to a file.

```java
package Serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serialize {
    public static void main(String[] args) throws IOException {
        User user = new User("Prasu", "abcd@123");

        FileOutputStream fileout = new FileOutputStream("UserInfo.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileout);
        out.writeObject(user);
        out.close();
        fileout.close();

        System.out.println("Object written successfully");
    }
}
```

### Deserialization Code
The `DeSerialize` class reads the saved `User` object from the file.

```java
package Serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeSerialize {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User user;

        FileInputStream fileInputStream = new FileInputStream("C:\Users\Dell\Desktop\Projects\Java\Core Java\UserInfo.ser");
        ObjectInputStream in = new ObjectInputStream(fileInputStream);
        user = (User) in.readObject();
        in.close();
        fileInputStream.close();

        System.out.println(user);
    }
}
```

## Explanation of Example
1. **User Class**: Implements `Serializable` with fields `name` and `password`. The `total` field is static, so it will not be serialized.
2. **Serialize Class**: Creates a `User` object and serializes it to the `UserInfo.ser` file.
3. **DeSerialize Class**: Reads the serialized `User` object from the file and prints it.