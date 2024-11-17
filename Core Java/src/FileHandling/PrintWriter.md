# PrintWriter Class

The `PrintWriter` class in Java is part of the `java.io` package. It is a character-based class used for writing formatted representations of objects to a text-output stream. It is especially useful in web applications when working with Servlets to send text data (such as HTML content) to the client.

## Key Features

- It supports methods to write strings, characters, and objects.
- Unlike other output streams, `PrintWriter` does not throw `IOException` during input-output operations.
- It can be wrapped around other output streams to provide additional functionality.

## Constructors

### 1. `PrintWriter(OutputStream out)`

Creates a new PrintWriter with the specified OutputStream.

**Example:**

```java
import java.io.PrintWriter;
import java.io.FileOutputStream;

public class PrintWriterExample1 {
    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream("output.txt");
        PrintWriter pw = new PrintWriter(fos);
        pw.println("This is an example of PrintWriter with OutputStream.");
        pw.close();
        System.out.println("Data written to file successfully.");
    }
}
```

### 2. `PrintWriter(Writer out)`

Creates a new PrintWriter with the specified Writer.

**Example:**

```java
import java.io.PrintWriter;
import java.io.StringWriter;

public class PrintWriterExample2 {
    public static void main(String[] args) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        pw.println("This is an example of PrintWriter with Writer.");
        pw.close();
        System.out.println("Output: " + sw.toString());
    }
}
```

### 3. `PrintWriter(String fileName)`

Creates a new PrintWriter to write to a file.

**Example:**

```java
import java.io.PrintWriter;

public class PrintWriterExample3 {
    public static void main(String[] args) throws Exception {
        PrintWriter pw = new PrintWriter("outputFile.txt");
        pw.println("This is an example of PrintWriter with a file name.");
        pw.close();
        System.out.println("File written successfully.");
    }
}
```

### 4. `PrintWriter(OutputStream out, boolean autoFlush)`

Creates a new PrintWriter with auto-flush enabled.

**Example:**

```java
import java.io.PrintWriter;
import java.io.FileOutputStream;

public class PrintWriterExample4 {
    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream("autoFlushOutput.txt");
        PrintWriter pw = new PrintWriter(fos, true);
        pw.println("This is an example of PrintWriter with autoFlush enabled.");
        pw.close();
        System.out.println("File written with autoFlush successfully.");
    }
}
```

## Commonly Used Methods

| Method                   | Description                            |
| ------------------------ | -------------------------------------- |
| `void print(String s)`   | Prints a string.                       |
| `void println(String s)` | Prints a string followed by a newline. |
| `void write(String s)`   | Writes a string.                       |
| `void flush()`           | Flushes the stream.                    |
| `void close()`           | Closes the stream.                     |
| `boolean checkError()`   | Checks for errors in the stream.       |

## Advantages

- Easy to use for writing text-based responses.
- Provides a range of methods for formatting and output.

## Disadvantages

- No built-in support for binary data (use `ServletOutputStream` for that).

## Use Cases

- Generating text-based reports or logs.
- Writing data to files in a character-encoded format.
