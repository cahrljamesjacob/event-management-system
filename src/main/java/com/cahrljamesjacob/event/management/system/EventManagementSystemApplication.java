package com.cahrljamesjacob.event.management.system;

import com.cahrljamesjacob.event.management.system.model.Event;
import com.cahrljamesjacob.event.management.system.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.Arrays;

@SpringBootApplication
public class EventManagementSystemApplication {
	public static void main(String[] args) {
		SpringApplication.run(EventManagementSystemApplication.class, args);
	}

}
