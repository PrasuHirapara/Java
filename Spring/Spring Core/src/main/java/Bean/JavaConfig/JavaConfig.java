package Bean.JavaConfig;

import IoC.Doctor;
import IoC.Nurse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = "IoC") // if not, then define Bean yourself using @Bean annotation
public class JavaConfig {

    @Bean
    public Nurse nurse() {
        return new Nurse();
    }

    @Bean
    public Doctor doctor() {
        return new Doctor(nurse());
    }
}
