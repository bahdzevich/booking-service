package com.bookingservice.repository;

import com.bookingservice.model.domain.PeriodForDay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeriodForDayRepository extends JpaRepository<PeriodForDay, Long> {
}
