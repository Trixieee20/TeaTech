package com.TeaTech.co.TeaTech.Service;


import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.TeaTech.co.TeaTech.Model.UserAuth;
import com.TeaTech.co.TeaTech.Repository.UserAuthRepository;

@Service
public class CustomUserAuthDetailService implements UserDetailsService{
    private UserAuthRepository userAuthRepository;

    public CustomUserAuthDetailService(UserAuthRepository userAuthRepository) {
        this.userAuthRepository = userAuthRepository;
    }

    public UserDetails loadUserByUserName(String usernameorEmail) throws UsernameNotFoundException{
        UserAuth userAuth = userAuthRepository.findByUsernameOrEmail(usernameorEmail, usernameorEmail)
            .orElseThrow(()->
            new UsernameNotFoundException("User not found with username or email" + usernameorEmail));

        Set<GrantedAuthority> authorities = userAuth
        .getRoles()
        .stream()
        .map((role) -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());

        return new org.springframework.security.core.userdetails.User(
            userAuth.getEmail(), 
            userAuth.getPassword(),
            authorities
        );
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'loadUserByUsername'");
    }

}

