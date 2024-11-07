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
