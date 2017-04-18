package pl.thewalkingcode.repository;

import org.springframework.stereotype.Repository;
import pl.thewalkingcode.model.User;

@Repository("userDao")
public class UserRepository extends GenericDaoImpl<User, String> {

    public UserRepository() {
        setEntityClass(User.class);
    }

    public User find(String username) {
        return super.read(username);
    }

    public User create(User user) {
        return super.create(user);
    }

}