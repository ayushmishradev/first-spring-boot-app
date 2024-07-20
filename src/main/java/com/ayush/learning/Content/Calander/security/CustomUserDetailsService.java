package com.ayush.learning.Content.Calander.security;

import com.ayush.learning.Content.Calander.entity.User;
import com.ayush.learning.Content.Calander.repository.UserRepositoryRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepositoryRepository userRepositoryRepository;

    public CustomUserDetailsService(UserRepositoryRepository userRepositoryRepository) {
        this.userRepositoryRepository = userRepositoryRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
       User user =  userRepositoryRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(() -> new UsernameNotFoundException(("user not found")));

        Set<GrantedAuthority> authorities = user.getRoles().stream().map((role) -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toSet());

        return  new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }
}
