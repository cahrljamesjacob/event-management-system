package com.cahrljamesjacob.event.management.system.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "event")
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "date_time")
    private String dateTime;
    @Column(name = "location")
    private String location;
    @Column(name = "description")
    private String description;
    @Column(name = "event_organizer")
    private String eventOrganizer;
    @ElementCollection
    @CollectionTable(name = "event_participants")
    @Column(name = "participants")
    private List<String> participants;
    @Column(name = "status")
    private String status;
}
