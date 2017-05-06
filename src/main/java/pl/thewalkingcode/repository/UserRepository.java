package pl.thewalkingcode.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.thewalkingcode.model.User;

@Repository("userDao")
public class UserRepository extends GenericDaoImpl<User, String> {

    public UserRepository() {
        setEntityClass(User.class);
    }

}
