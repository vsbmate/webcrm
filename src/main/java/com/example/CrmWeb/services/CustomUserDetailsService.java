package com.example.CrmWeb.services;


import com.example.CrmWeb.repositories.RepositoryUsers;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final RepositoryUsers repositoryUsers;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return repositoryUsers.findByEmail(email);
    }
}
