package com.bookingservice.model.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

/**
 * A class represents a {@link Provider} working schedule for a particular date. It includes a set
 * of {@link PeriodForDate}. Each of them means an interval of working time (start, end). If there
 * exists an object of {@link ScheduleForDate} but its set is empty, {@link Provider} will have a
 * weekend for the particular date. {@link ScheduleForDate} has greater priority than {@link
 * ScheduleForDay} in terms of checking {@link Provider} schedule.
 */
@Entity
@Table(name = "SCH_FOR_DATE")
@Data
@NoArgsConstructor
public class ScheduleForDate {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  private LocalDate localDate;

  @OneToMany(mappedBy = "scheduleForDate")
  private Set<PeriodForDate> periodForDateSet;

  @ManyToOne(fetch = FetchType.LAZY)
  private Provider provider;
}
