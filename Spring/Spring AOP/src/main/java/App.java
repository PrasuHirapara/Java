import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

        ShoppingCart shoppingCart = context.getBean(ShoppingCart.class);
        shoppingCart.checkout("CANCELLED");
        System.out.println(shoppingCart.quantity());
    }
}
