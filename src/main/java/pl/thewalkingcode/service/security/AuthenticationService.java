package pl.thewalkingcode.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.thewalkingcode.model.Role;
import pl.thewalkingcode.model.User;
import pl.thewalkingcode.repository.GenericDao;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    @Qualifier("userDao")
    private GenericDao<User, String> userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.read(username);
        if (user != null) {
            List<GrantedAuthority> roles = new ArrayList<>();
            for (Role role : user.getRoles()) {
                roles.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
            }

            UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                    username,
                    user.getPassword(),
                    user.isEnabled(),
                    true,
                    true,
                    true,
                    roles
            );
            return userDetails;
        } else {
            throw new UsernameNotFoundException("No user with username " + username + " not found!");
        }
    }

}
