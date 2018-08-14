package com.bookingservice.repository;

import com.bookingservice.model.domain.PeriodForDate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeriodForDateRepository extends JpaRepository<PeriodForDate, Long> {
}
