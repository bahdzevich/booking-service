package com.bookingservice.repository;

import com.bookingservice.model.domain.ScheduleForDate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleForDateRepository extends JpaRepository<ScheduleForDate, Long> {
}
