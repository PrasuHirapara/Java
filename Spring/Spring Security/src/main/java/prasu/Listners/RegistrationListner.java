package prasu.Listners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import prasu.Entity.User;
import prasu.Event.RegistrationEvent;
import prasu.Service.UserService;

import java.util.UUID;

@Component
@Slf4j
public class RegistrationListner implements ApplicationListener<RegistrationEvent> {

    @Autowired
    private UserService userService;

    @Override
    public void onApplicationEvent(RegistrationEvent event) {
//        Generate the verification token for the user with link.
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        userService.saveVerificationForUser(token, user);

//        send mail to user
        String url = event.getApplicationUrl()
                + "/verifyRegistration?token="
                + token;
        log.info(url);
    }

    @Override
    public boolean supportsAsyncExecution() {
        return ApplicationListener.super.supportsAsyncExecution();
    }
}
