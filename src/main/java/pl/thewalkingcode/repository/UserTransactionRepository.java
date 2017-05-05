package pl.thewalkingcode.repository;

import org.springframework.stereotype.Repository;
import pl.thewalkingcode.model.UserTransaction;

@Repository("userTransactionDao")
public class UserTransactionRepository extends GenericDaoImpl<UserTransaction, Integer> {

    public UserTransactionRepository() {
        setEntityClass(UserTransaction.class);
    }

}
