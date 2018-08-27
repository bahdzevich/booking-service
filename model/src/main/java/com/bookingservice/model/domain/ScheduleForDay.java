package com.bookingservice.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.DayOfWeek;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

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

  @JsonIgnore
  @OneToMany(mappedBy = "scheduleForDay")
  private Set<PeriodForDay> periodForDaySet = new HashSet<>();

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  private Provider provider;
}
