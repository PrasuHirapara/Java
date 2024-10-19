package OOPs.Interface;

public interface Engine {

    int price = 99999;

    default void start() {
        System.out.println("Starting Engine default");
    }
    void stop();
    void accelerate();
}
