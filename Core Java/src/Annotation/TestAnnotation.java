package Annotation;

public class TestAnnotation {

    @MyCustomAnnotation(value = "This is custom annotation")
    public void display() {
        System.out.println("Inside display method of TestAnnotation");
    }
}
