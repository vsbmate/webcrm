package com.example.CrmWeb.repositories;

import com.example.CrmWeb.models.EventModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface RepositoryEvents extends JpaRepository<EventModel, Long> {
    List<EventModel> findByPhoneNumber(String phoneNumber);
    boolean existsByTime(LocalDateTime time);

}
