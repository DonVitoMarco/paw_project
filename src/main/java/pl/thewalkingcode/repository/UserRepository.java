package pl.thewalkingcode.repository;

import org.springframework.stereotype.Repository;
import pl.thewalkingcode.model.User;

@Repository
public class UserRepository extends GenericDaoImpl<User, Integer> {

}