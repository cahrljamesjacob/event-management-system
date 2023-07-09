package com.cahrljamesjacob.event.management.system.repository;

import com.cahrljamesjacob.event.management.system.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
}
