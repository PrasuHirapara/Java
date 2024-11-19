package OOPs.Generics;

public class Main {
    public static void main(String[] args) {
//        CustomArrayList<String> list = new CustomArrayList<>();
        CustomArrayList<Integer> list = new CustomArrayList<>();

        for (int i = 1; i < 10; i++) {
            list.add(i);
        }

        System.out.println(list.remove());
        list.display();
    }
}