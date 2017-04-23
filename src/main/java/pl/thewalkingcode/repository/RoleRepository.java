package pl.thewalkingcode.repository;

import org.springframework.stereotype.Repository;
import pl.thewalkingcode.model.Role;

@Repository("roleDao")
public class RoleRepository extends GenericDaoImpl<Role, Integer> {

    public RoleRepository() {
        setEntityClass(Role.class);
    }

}
