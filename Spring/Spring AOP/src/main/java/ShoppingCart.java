import org.springframework.stereotype.Component;

@Component
public class ShoppingCart {

    public void checkout(String status) {
//        Logging
//        Authentication and Authorization
//        Sanitization of data
//        create aspects as it can be re-usable
        System.out.println("Shopping cart.checkout " + status);
    }

    public int quantity() {
        return 1;
    }
}
