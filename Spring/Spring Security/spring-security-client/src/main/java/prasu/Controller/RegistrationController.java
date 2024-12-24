package prasu.Controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;
import prasu.Entity.User;
import prasu.Entity.VerificationToken;
import prasu.Event.RegistrationEvent;
import prasu.Model.PasswordModel;
import prasu.Model.UserModel;
import prasu.Repository.VerificationTokenRepository;
import prasu.Service.UserService;
import java.util.Optional;
import java.util.UUID;

@RestController
@Slf4j
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

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

    @PostMapping("/resetPassword")
    public String resetPassword(@RequestBody PasswordModel passwordModel, HttpServletRequest request) {
        User user = userService.findUserByEmail(passwordModel.getEmail());
        String url = "";

        if(user != null) {
            String token = UUID.randomUUID().toString();
            userService.createPasswordResetTokenforUser(user, token);
            url = passwordResetMail(user, applicationUrl(request), token);
        }
        log.info("Reset password link: " + url);
        return url;
    }

    @PostMapping("/savePassword")
    public String savePassword(
            @RequestParam("token") String token,
            @RequestBody PasswordModel passwordModel
    ) {
        String result = userService.validatePasswordResetToken(token);

        if(!result.equalsIgnoreCase("valid")) {
            return "Invalid token";
        }

        Optional<User> user = userService.getUserByPasswordResetToken(token);
        if(user.isPresent()) {
            userService.changePassword(user.get(), passwordModel.getNewPassword());
            return "Password reset successfully";
        }else {
            return "Invalid token";
        }
    }

    @PostMapping("/changePassword")
    public String changePassword(@RequestBody PasswordModel passwordModel) {
        User user = userService.findUserByEmail(passwordModel.getEmail());

        if(!userService.checkIfValidPassword(user, passwordModel.getOldPassword())) {
            return "Invalid old password";
        }

        userService.changePassword(user, passwordModel.getNewPassword());

        return "Password changed successfully";
    }

    private String passwordResetMail(User user, String applicationUrl, String token) {
        String url = applicationUrl
                + "/savePassword?token="
                + token;

        log.info("Click url to verify account {}", url);

        return url;
    }

    private void resendVerificationMail(User user, String applicationUrl, VerificationToken verificationToken) {
        String url = applicationUrl
                + "/verifyRegistration?token="
                + verificationToken.getToken();

        log.info("Click url to regenerate token {}", url);
    }

    private String applicationUrl(HttpServletRequest request) {
        return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }
}
