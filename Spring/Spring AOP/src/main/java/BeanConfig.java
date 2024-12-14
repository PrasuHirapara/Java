import Aspects.AuthenticationAspect;
import Aspects.LoggingAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "java")
@EnableAspectJAutoProxy
public class BeanConfig {

    @Bean
    public ShoppingCart shoppingCart() {
        return new ShoppingCart();
    }

    @Bean
    public LoggingAspect loggingAspect() {
        return new LoggingAspect();
    }

    @Bean
    public AuthenticationAspect authenticationAspect() {
        return new AuthenticationAspect();
    }
}
