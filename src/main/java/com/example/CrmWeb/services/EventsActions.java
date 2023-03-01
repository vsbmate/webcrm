package com.example.CrmWeb.services;

import com.example.CrmWeb.models.EventModel;
import com.example.CrmWeb.models.UserAdmin;
import com.example.CrmWeb.repositories.RepositoryEvents;
import com.example.CrmWeb.repositories.RepositoryUsers;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.security.Principal;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class EventsActions extends EventModel{

    private final RepositoryEvents repositoryEvents;
    private final RepositoryUsers repositoryUsers;


    public List<EventModel> listEvents(String phoneNumber) {
        if(phoneNumber != null){
            return repositoryEvents.findByPhoneNumber(phoneNumber);
        }
        return repositoryEvents.findAll();
    }
    //saveEvent method for create a new event
    public void saveEvent(EventModel event) {
        log.info("Saving new {}", event);
        repositoryEvents.save(event);
    }

    public UserAdmin getUserByPrincipal(Principal principal) {
        if(principal == null) return new UserAdmin();
        return  repositoryUsers.findByEmail(principal.getName());
    }

    //delete evend by id
    public void deleteEvent(Long id) {
        repositoryEvents.deleteById(id);
    }

    //get any created event by id. If event doesn't created return null
    public EventModel getEventById(Long id){
        return repositoryEvents.findById(id).orElse(null);
    }

}
