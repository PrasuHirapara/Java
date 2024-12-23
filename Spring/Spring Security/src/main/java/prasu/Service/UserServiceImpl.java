package prasu.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import prasu.Entity.PasswordResendToken;
import prasu.Entity.User;
import prasu.Entity.VerificationToken;
import prasu.Model.UserModel;
import prasu.Repository.PasswordResendRepository;
import prasu.Repository.UserRepository;
import prasu.Repository.VerificationTokenRepository;

import java.util.Calendar;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VerificationTokenRepository verificationTokenRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private PasswordResendRepository passwordResendRepository;

    @Override
    public User registerUser(UserModel userModel) {
        User user = new User();

        user.setFirstName(userModel.getFirstName());
        user.setLastName(userModel.getLastName());
        user.setEmail(userModel.getEmail());
        user.setRole("USER");
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));

        userRepository.save(user);

        return user;
    }

    @Override
    public void saveVerificationForUser(String token, User user) {
        VerificationToken verificationToken = new VerificationToken(user, token);
        verificationTokenRepository.save(verificationToken);
    }

    @Override
    public String validateVerificationToken(String token) {
        VerificationToken verificationToken = verificationTokenRepository.findByToken(token);

        if(verificationToken == null) {
            return "Invalid verification token";
        }

        User user = verificationToken.getUser();
        Calendar calendar = Calendar.getInstance();

        if(verificationToken.getExpirationTime().getTime() - calendar.getTime().getTime() < 0) {
            verificationTokenRepository.delete(verificationToken);
            return "Expired token";
        }

        user.setEnabled(true);
        userRepository.save(user);

        return "valid";
    }

    @Override
    public VerificationToken generateNewVerificationToken(String oldToken) {
        VerificationToken verificationToken = verificationTokenRepository.findByToken(oldToken);

        verificationToken.setToken(UUID.randomUUID().toString());
        verificationTokenRepository.save(verificationToken);

        return verificationToken;
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void createPasswordResetTokenforUser(User user, String token) {
        PasswordResendToken passwordResendToken = new PasswordResendToken(user, token);

        passwordResendRepository.save(passwordResendToken);
    }

    @Override
    public String validatePasswordResetToken(String token) {
        PasswordResendToken passwordResendToken = passwordResendRepository.findByToken(token);

        if(passwordResendToken == null) {
            return "Invalid verification token";
        }

        User user = passwordResendToken.getUser();
        Calendar calendar = Calendar.getInstance();

        if(passwordResendToken.getExpirationTime().getTime() - calendar.getTime().getTime() < 0) {
            passwordResendRepository.delete(passwordResendToken);
            return "Expired token";
        }

        return "valid";
    }

    @Override
    public Optional<User> getUserByPasswordResetToken(String token) {
        return Optional.ofNullable(passwordResendRepository.findByToken(token).getUser());
    }

    @Override
    public void changePassword(User user, String newPassword) {
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
    }

    @Override
    public boolean checkIfValidPassword(User user, String oldPassword) {
        return passwordEncoder.matches(oldPassword, user.getPassword());
    }
}
