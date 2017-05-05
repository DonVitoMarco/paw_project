package pl.thewalkingcode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.thewalkingcode.model.User;
import pl.thewalkingcode.model.UserTransaction;
import pl.thewalkingcode.model.dto.UserBuyItemDto;
import pl.thewalkingcode.repository.GenericDao;
import pl.thewalkingcode.service.api.UserTransactionService;

import java.math.BigDecimal;
import java.util.Date;

@Service("userTransactionService")
@Transactional
public class UserTransactionServiceImpl implements UserTransactionService {

    @Autowired
    @Qualifier("userTransactionDao")
    private GenericDao<UserTransaction, Integer> userTransactionalRepository;

    @Override
    public UserTransaction addTransaction(UserBuyItemDto userBuyItemDto, User user) {
        UserTransaction userTransaction = new UserTransaction();
        userTransaction.setUser(user);
        userTransaction.setDate(new Date());
        userTransaction.setCode(userBuyItemDto.getCode());
        userTransaction.setFullname(userBuyItemDto.getFullname());
        userTransaction.setPrice(userBuyItemDto.getPrice());
        userTransaction.setUnit(userBuyItemDto.getUnit());
        userTransaction.setAmount(userBuyItemDto.getPrice().multiply(new BigDecimal(userBuyItemDto.getUnit())));
        userTransaction = userTransactionalRepository.create(userTransaction);
        return userTransaction;
    }

}
