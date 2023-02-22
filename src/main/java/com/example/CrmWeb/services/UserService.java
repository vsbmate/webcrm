package com.example.CrmWeb.services;


import com.example.CrmWeb.models.Role;
import com.example.CrmWeb.models.UserAdmin;
import com.example.CrmWeb.repositories.RepositoryUsers;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final RepositoryUsers repositoryUsers;
    private final PasswordEncoder passwordEncoder;

    public boolean createUser (UserAdmin userAdmin) {
        String email = userAdmin.getEmail();
        if(repositoryUsers.findByEmail(email) != null) return false;
        userAdmin.setActive(true);
        userAdmin.setPassword(passwordEncoder.encode(userAdmin.getPassword()));
        userAdmin.getRoles().add(Role.ROLE_ADMIN);
        log.info("Saving new user with email: {}", email);
        repositoryUsers.save(userAdmin);
        return true;
    }
}
