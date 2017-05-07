package pl.thewalkingcode.repository;

import org.springframework.stereotype.Repository;
import pl.thewalkingcode.model.EventAccount;

@Repository("eventDao")
public class EventRepository extends GenericDaoImpl<EventAccount, Integer> {

    public EventRepository() {
        setEntityClass(EventAccount.class);
    }

}
