package OOPs.Interface;

public class Car implements Engine, Brake, Media{
    @Override
    public void stop() {
        System.out.println("Engine stopping...");
    }

    @Override
    public void accelerate() {
        System.out.println("Engine accelerating...");
    }

    @Override
    public void brake() {
        System.out.println("Car braking...");
    }

    @Override
    public void unpause() {
        System.out.println("song unpaused...");
    }

    @Override
    public void pause() {
        System.out.println("song paused...");
    }
}
