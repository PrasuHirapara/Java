# Networking
Java provides several classes and interfaces to support network programming. Network programming in Java allows applications to communicate over a network, sharing resources and data. Key concepts in networking include **port numbers**, **MAC addresses**, **IP addresses**, **protocols (TCP/UDP)**, and **client-server communication**.

### Important Terms
- **MAC Address**: A unique identifier assigned to network interfaces for communications on the physical network segment.
```java
package Networking;

import java.net.NetworkInterface;
import java.net.SocketException;

public class MAC_Address {
    public static void main(String[] args) {

        try {
            NetworkInterface network = NetworkInterface.getByName("ethernet_1"); // network interface name
            System.out.println(network);

            byte[] macAddress = network.getHardwareAddress();

            // Display the MAC address in standard format
            StringBuilder macString = new StringBuilder();
            for (int i = 0; i < macAddress.length; i++) {
                macString.append(String.format("%02X%s", macAddress[i], (i < macAddress.length - 1) ? "-" : ""));
            }
            System.out.println("MAC Address: " + macString);

        } catch (SocketException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

```
- **Port Number**: A numeric label for each application or service on a networked device, allowing proper routing of data.

## Networking Classes and Interfaces in Java

### NetworkInterface
The `NetworkInterface` class represents a network interface on the local machine.

**Methods**:
- `getName()`: Returns the name of the network interface.
- `getDisplayName()`: Provides a human-readable display name for the interface.
- `getHardwareAddress()`: Returns the MAC address as a byte array.
- `getInetAddresses()`: Returns an enumeration of all the IP addresses bound to this network interface.

**Example**:
```java
import java.net.*;
import java.util.*;

public class NetworkInterfaceExample {
    public static void main(String[] args) throws SocketException {
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        while (interfaces.hasMoreElements()) {
            NetworkInterface ni = interfaces.nextElement();
            System.out.println("Interface Name: " + ni.getName());
            System.out.println("Display Name: " + ni.getDisplayName());

            byte[] mac = ni.getHardwareAddress();
            if (mac != null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < mac.length; i++) {
                    sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
                }
                System.out.println("MAC Address: " + sb.toString());
            }
            System.out.println();
        }
    }
}
```

### Socket
The `Socket` class provides client-side TCP socket communication.

**Methods**:
- `connect(SocketAddress endpoint)`: Connects this socket to the specified endpoint.
- `getInputStream()`: Returns an input stream for reading bytes from the socket.
- `getOutputStream()`: Returns an output stream for sending bytes to the socket.

**Example**:
```java
import java.io.*;
import java.net.*;

public class SocketExample {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8080);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            out.println("Hello Server!");
            System.out.println("Server says: " + in.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### DatagramSocket
The `DatagramSocket` class is used for sending and receiving datagram packets in UDP communication.

**Methods**:
- `send(DatagramPacket p)`: Sends a datagram packet.
- `receive(DatagramPacket p)`: Receives a datagram packet.

**Example**:
```java
import java.net.*;

public class DatagramSocketExample {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket()) {
            String message = "Hello, UDP Server!";
            byte[] buffer = message.getBytes();

            InetAddress address = InetAddress.getByName("localhost");
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 9876);
            socket.send(packet);

            System.out.println("Message sent to server.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

### InetAddress
The `InetAddress` class represents an IP address.

**Methods**:
- `getByName(String host)`: Returns an InetAddress for the given hostname.
- `getHostAddress()`: Returns the IP address as a string.

**Example**:
```java
import java.net.*;

public class InetAddressExample {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getByName("localhost");
        System.out.println("Host Address: " + address.getHostAddress());
        System.out.println("Host Name: " + address.getHostName());
    }
}
```

### URL
The `URL` class represents a Uniform Resource Locator.

**Methods**:
- `getProtocol()`: Returns the protocol of the URL.
- `getHost()`: Returns the hostname of the URL.
- `getPort()`: Returns the port number.

**Example**:
```java
import java.net.*;

public class URLExample {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://www.example.com:80/path");
        System.out.println("Protocol: " + url.getProtocol());
        System.out.println("Host: " + url.getHost());
        System.out.println("Port: " + url.getPort());
    }
}
```

## Client-Server Communication Example

### Server Code
```java
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("Server is listening on port 8080");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            String message = input.readLine();
            System.out.println("Received from client: " + message);
            output.println("Hello from server!");
        }
    }
}
```

### Client Code
```java
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8080);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            out.println("Hello Server!");
            System.out.println("Server says: " + in.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```
