package prasu.Service;

import prasu.Entity.User;
import prasu.Model.UserModel;

public interface UserService {

    User registerUser(UserModel userModel);

    void saveVerificationForUser(String token, User user);

    String validateVerificationToken(String token);
}
