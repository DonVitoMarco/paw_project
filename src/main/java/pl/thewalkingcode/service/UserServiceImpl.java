package pl.thewalkingcode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.thewalkingcode.model.Account;
import pl.thewalkingcode.model.Role;
import pl.thewalkingcode.model.User;
import pl.thewalkingcode.model.dto.NewUserDto;
import pl.thewalkingcode.repository.GenericDao;
import pl.thewalkingcode.service.api.UserService;

import java.math.BigDecimal;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("userDao")
    private GenericDao<User, String> userRepository;

    @Autowired
    @Qualifier("roleDao")
    private GenericDao<Role, Integer> roleRepository;

    @Autowired
    @Qualifier("accountDao")
    private GenericDao<Account, Integer> accountRepository;

    @Override
    public User createUser(NewUserDto newUserDto) {
        User user = new User();
        user.setUsername(newUserDto.getUsername());
        user.setPassword(newUserDto.getPassword());
        user.setEnabled(true);
        user = userRepository.create(user);

        Role role = new Role();
        role.setRoleName("USER");
        role.setUser(user);
        roleRepository.create(role);

        Account account = new Account();
        account.setWallet(BigDecimal.ZERO);
        account.setUser(user);
        accountRepository.create(account);

        return user;
    }

    @Override
    public boolean isUsernameExist(String username) {
        return userRepository.read(username) != null;
    }

    @Override
    public User find(String pk) {
        return userRepository.read(pk);
    }

    public User update(User user) {
        return userRepository.update(user);
    }

}
