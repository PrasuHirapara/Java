package Annotation;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws Exception {
        TestAnnotation obj = new TestAnnotation();
        Method method = obj.getClass().getMethod("display");

        // Check if the method has MyCustomAnnotation
        if (method.isAnnotationPresent(MyCustomAnnotation.class)) {
            MyCustomAnnotation annotation = method.getAnnotation(MyCustomAnnotation.class);
            System.out.println("Annotation Value: " + annotation.value());
        }

        // Calling the method
        obj.display();
    }
}
