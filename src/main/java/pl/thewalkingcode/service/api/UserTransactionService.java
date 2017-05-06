package pl.thewalkingcode.service.api;

import pl.thewalkingcode.model.User;
import pl.thewalkingcode.model.UserTransaction;
import pl.thewalkingcode.model.dto.SellTransactionDto;
import pl.thewalkingcode.model.dto.UserBuyItemDto;

public interface UserTransactionService {

    UserTransaction addTransaction(UserBuyItemDto userBuyItemDto, User user);

    UserTransaction find(Integer pk);

    UserTransaction sell(SellTransactionDto sellTransactionDto);

}
