package OOPs.Package;
import static OOPs.Class.Student.getStudent;

import java.net.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        getStudent();

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        System.out.print(list);

        try {
            URL url = new URL("http://youtube.com");
            URLConnection conn = url.openConnection();
            System.out.println("Content Type: " + conn.getContent().toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
