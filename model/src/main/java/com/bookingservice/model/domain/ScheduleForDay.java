package com.bookingservice.model.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.util.Set;

/**
 * A class represents a {@link Provider} working schedule for a particular day of week. It includes
 * a set of {@link PeriodForDay}. Each of them means an interval of working time (start, end). If
 * the set is empty, provider will have a weekend for a particular day of week. {@link
 * ScheduleForDay} has less priority than {@link ScheduleForDate} in terms of checking provider
 * schedule
 */
@Entity
@Table(name = "SCH_FOR_DAY")
@Data
@NoArgsConstructor
public class ScheduleForDay {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  private DayOfWeek dayOfWeek;

  @OneToMany(mappedBy = "scheduleForDay")
  private Set<PeriodForDay> periodForDaySet;

  @ManyToOne(fetch = FetchType.LAZY)
  private Provider provider;
}
