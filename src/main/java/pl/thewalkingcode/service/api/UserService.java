package pl.thewalkingcode.service.api;

import pl.thewalkingcode.model.User;
import pl.thewalkingcode.model.UserTransaction;
import pl.thewalkingcode.model.dto.NewUserDto;

import java.util.List;

public interface UserService {

    User createUser(NewUserDto newUserDto);

    boolean isUsernameExist(String username);

    User find(String pk);

    User update(User user);

    List<UserTransaction> getUserTransaction(String username);

}
