package com.cahrljamesjacob.event.management.system.model;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class EventDto {
    private String title;
    private String dateTime;
    private String location;
    private String description;
    private String eventOrganizer;
    private List<String> participants;
    private String status;
}
