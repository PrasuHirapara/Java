package IoC;

import org.springframework.stereotype.Component;

@Component
public class Nurse implements Staff{

    @Override
    public void assist() {
        System.out.println("Nurse is assisting");
    }
}
