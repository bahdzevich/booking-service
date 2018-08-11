package com.bookingservice.model.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * A class for a company account. A company account is used to manage the following entities: {@link
 * Service}, {@link Provider}, {@link ScheduleForDate}, {@link PeriodForDate}, {@link
 * ScheduleForDay}, {@link PeriodForDay}, {@link Reservation}, {@link Client}
 */
@Entity
@Table(name = "COMPANY")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Company extends User {

  private String description;
}
