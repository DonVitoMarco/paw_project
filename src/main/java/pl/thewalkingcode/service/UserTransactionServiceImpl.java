package pl.thewalkingcode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.thewalkingcode.model.User;
import pl.thewalkingcode.model.UserTransaction;
import pl.thewalkingcode.model.dto.SellTransactionDto;
import pl.thewalkingcode.model.dto.UserBuyItemDto;
import pl.thewalkingcode.repository.GenericDao;
import pl.thewalkingcode.service.api.UserTransactionService;
import pl.thewalkingcode.util.Utils;

import java.math.BigDecimal;
import java.util.Date;

@Service("userTransactionService")
@Transactional
public class UserTransactionServiceImpl implements UserTransactionService {

    @Autowired
    @Qualifier("userTransactionDao")
    private GenericDao<UserTransaction, Integer> userTransactionalRepository;

    @Autowired
    @Qualifier("userDao")
    private GenericDao<User, String> userRepository;

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

    @Override
    public UserTransaction find(Integer pk) {
        return userTransactionalRepository.read(pk);
    }

    @Override
    public UserTransaction sell(SellTransactionDto sellTransactionDto) {
        UserTransaction ut = find(sellTransactionDto.getIdUserTranscation());

        BigDecimal addToWallet = ut.getPrice().multiply(new BigDecimal(sellTransactionDto.getUnit()));
        int newUnit = ut.getUnit() - sellTransactionDto.getUnit();
        BigDecimal newAmount = ut.getPrice().multiply(new BigDecimal(newUnit));

        ut.setUnit(newUnit);
        ut.setAmount(newAmount);
        UserTransaction userTransaction = userTransactionalRepository.update(ut);

        User user = userRepository.read(Utils.getCurrentUsername());
        BigDecimal wallet = user.getAccount().getWallet();
        user.getAccount().setWallet(wallet.add(addToWallet));

        return userTransaction;
    }

}
