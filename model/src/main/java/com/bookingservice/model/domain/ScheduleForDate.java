package com.bookingservice.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDate;
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

  @JsonIgnore
  @OneToMany(mappedBy = "scheduleForDate")
  private Set<PeriodForDate> periodForDateSet = new HashSet<>();

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  private Provider provider;
}
