package Serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeSerialize {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User user;

        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Dell\\Desktop\\Projects\\Java\\Core Java\\UserInfo.ser");
        ObjectInputStream in = new ObjectInputStream(fileInputStream);
        user = (User) in.readObject();
        in.close();
        fileInputStream.close();

        System.out.println(user);
    }
}
