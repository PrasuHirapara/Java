package prasu.Controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;
import prasu.Entity.User;
import prasu.Entity.VerificationToken;
import prasu.Event.RegistrationEvent;
import prasu.Model.UserModel;
import prasu.Repository.VerificationTokenRepository;
import prasu.Service.UserService;

@RestController
@Slf4j
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private ApplicationEventPublisher eventPublisher;
    @Autowired
    private VerificationTokenRepository verificationTokenRepository;

    @PostMapping("/register")
    public String registerUser(@RequestBody UserModel userModel, final HttpServletRequest request) {
        User user = userService.registerUser(userModel);

        eventPublisher.publishEvent(new RegistrationEvent(
                user,
                applicationUrl(request)
        ));

        return "Success";
    }

    @GetMapping("/verifyRegistration")
    public String verifyRegistration(@RequestParam("token") String token) {
        String result = userService.validateVerificationToken(token);

        if(result.equalsIgnoreCase("valid")) {
            return "valid";
        } else {
            return "Bad user";
        }
    }

    @GetMapping("/resendVerifyToken")
    public String resendVerificationToken(
            @RequestParam("token") String oldToken,
            HttpServletRequest request
    ) {
        VerificationToken verificationToken = userService.generateNewVerificationToken(oldToken);

        User user = verificationToken.getUser();
        resendVerificationMail(user, applicationUrl(request), verificationToken);

        return "Verification Link sent";
    }

//    @PostMapping("/resetPassword")
//    public String resetPassword(@RequestParam("token") String token) {
//
//    }

    private void resendVerificationMail(User user, String applicationUrl, VerificationToken verificationToken) {
        String url = applicationUrl
                + "/verifyRegistration?token="
                + verificationToken.getToken();

        log.info(url);
    }

    private String applicationUrl(HttpServletRequest request) {
        return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }
}
