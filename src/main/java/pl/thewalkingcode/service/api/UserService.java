package pl.thewalkingcode.service.api;

import pl.thewalkingcode.model.User;
import pl.thewalkingcode.model.dto.NewUserDto;

public interface UserService {

    User createUser(NewUserDto newUserDto);

}
