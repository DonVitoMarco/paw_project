package pl.thewalkingcode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.thewalkingcode.model.EventAccount;
import pl.thewalkingcode.repository.GenericDao;
import pl.thewalkingcode.service.api.EventAccountService;

import java.util.List;

@Service("eventAccountService")
@Transactional
public class EventAccountServiceImpl implements EventAccountService {

    @Autowired
    @Qualifier("eventDao")
    private GenericDao<EventAccount, Integer> userEventRepository;

    @Override
    public List<EventAccount> getAllEvents() {
        return userEventRepository.readAll();
    }

}
