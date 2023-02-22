package com.example.CrmWeb.repositories;

import com.example.CrmWeb.models.UserAdmin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryUsers extends JpaRepository<UserAdmin, Long> {
    UserAdmin findByEmail(String email);
}
