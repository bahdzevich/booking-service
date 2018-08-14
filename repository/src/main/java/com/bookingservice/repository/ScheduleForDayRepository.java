package com.bookingservice.repository;

import com.bookingservice.model.domain.ScheduleForDay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleForDayRepository extends JpaRepository<ScheduleForDay, Long> {
}
