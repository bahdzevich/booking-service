package com.bookingservice.model.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalTime;

/** A class is used to represent an interval o working time for a particular date. */
@Entity
@Table(name = "PER_FOR_DATE")
@Data
@NoArgsConstructor
public class PeriodForDate {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  private LocalTime start;
  private LocalTime end;

  @ManyToOne(fetch = FetchType.LAZY)
  private ScheduleForDate scheduleForDate;
}
