package prasu.Event;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;
import prasu.Entity.User;

@Getter
@Setter
public class RegistrationEvent extends ApplicationEvent {

    private User user;
    private String applicationUrl;

    public RegistrationEvent(User user, String applicationUrl) {
        super(user);
        this.user = user;
        this.applicationUrl = applicationUrl;
    }
}
