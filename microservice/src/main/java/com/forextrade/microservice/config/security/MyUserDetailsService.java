package com.forextrade.microservice.config.security;

import com.forextrade.microservice.model.User;
import com.forextrade.microservice.respository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmailId();
        if(user == null){
            throw new UsernameNotFoundException("User not found");
        }else{
            return new UserPrincipal(user);
        }
    }
}
