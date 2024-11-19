package OOPs.Generics;

public class CustomArrayList <T> {
    private T[] array;
    private int index = 0;

    public CustomArrayList() {
        this.array = (T[]) new Object[10];
    }

    public CustomArrayList(int size) {
        this.array = (T[]) new Object[size];
    }

    public void add(T element) {
        if (index == array.length) {
            return;
        }
        array[index++] = element;
    }

    public T remove() {
        if (index == 0) {
            return null;
        }
        return array[--index];
    }

    public T get(int index) {
        return array[index];
    }

    public void display() {
        for(int i = 0; i < index; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
