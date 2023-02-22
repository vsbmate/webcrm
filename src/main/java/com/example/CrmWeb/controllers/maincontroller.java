package com.example.CrmWeb.controllers;

import com.example.CrmWeb.models.EventModel;
import com.example.CrmWeb.services.EventsActions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDateTime;


@Controller
@RequiredArgsConstructor
public class maincontroller {
    private final EventsActions finEventsActions;

    //admin panel
    @GetMapping("/admin")
    public String adminPanel(Model model, @RequestParam(name = "phoneNumber", required = false) String phoneNumber){
        model.addAttribute("events", finEventsActions.listEvents(phoneNumber));
        return "adminPanel";
    }

    //main page for creating events
    @RequestMapping("/")
    public String mainPage(Model model, @RequestParam(name = "phoneNumber", required = false) String phoneNumber){
        model.addAttribute("events", finEventsActions.listEvents(phoneNumber));
        return "main";
    }

    //getting event information
    @GetMapping("/event/{id}")
    public String eventInfo(@PathVariable Long id, Model model){
        model.addAttribute("event", finEventsActions.getEventById(id));

        return "info";
    }
    @GetMapping("/")
    public String formGet(Model model) {
        model.addAttribute("event", new EventModel());
        return "main";
    }

    //create a new event
    @PostMapping("/")
    public String createEvent(@ModelAttribute("event")@Valid EventModel event, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "main";
        }
        if(event.getTime().isAfter(LocalDateTime.now())) {
            finEventsActions.saveEvent(event);
            return "redirect:/";
        }else{
            return "unavailableTime";
        }
    }

    //delete event by id
    @PostMapping("/event/delete/{id}")
    public String deleteEvent(@PathVariable Long id) {
        finEventsActions.deleteEvent(id);
        return "redirect:/admin";
    }
}
