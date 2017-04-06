package pl.thewalkingcode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.thewalkingcode.model.User;
import pl.thewalkingcode.repository.GenericDao;
import pl.thewalkingcode.service.api.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private GenericDao<User, Integer> userRepository;

}
