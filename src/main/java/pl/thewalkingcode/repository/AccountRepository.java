package pl.thewalkingcode.repository;

import org.springframework.stereotype.Repository;
import pl.thewalkingcode.model.Account;

@Repository("accountDao")
public class AccountRepository extends GenericDaoImpl<Account, Integer> {

    public AccountRepository() {
        setEntityClass(Account.class);
    }

}
