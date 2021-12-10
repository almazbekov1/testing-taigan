package peaksoft.taigan.db.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import peaksoft.taigan.db.domain.model.User;
import peaksoft.taigan.db.repo.UserRepo;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepo userRepository;

    public UserDetailsServiceImpl(UserRepo userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findUserByLogin(s).orElse(null);
        if (user == null) {
            throw new UsernameNotFoundException("user does not exist");
        }
        return new UserDetailsImpl(user);
    }
}
