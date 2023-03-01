package com.example.CrmWeb.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table (name = "events")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    @NotEmpty(message = "Укажите имя!")
    private String name;

    @Column(name = "phoneNumber")
    @NotEmpty(message = "Поле не должно быть пустым.")
    @Size(min = 11, max = 12, message = "Неверно введен номер телефона.")
    private String phoneNumber;

    @Column(name = "service")
    @NotEmpty(message = "Услуга не выбрана.")
    private String service;

    @Column(name = "time")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime time;

    @Column(name="timeOfEnd")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime timeOfEnd;

    public void setTimeOfEnd() {this.timeOfEnd = time.plusHours(1);
    }

}

