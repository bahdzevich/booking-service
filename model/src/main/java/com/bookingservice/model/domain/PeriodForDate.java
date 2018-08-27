package com.bookingservice.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalTime;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

/** A class is used to represent an interval o working time for a particular date. */
@Entity
@Table(name = "PER_FOR_DATE")
@Data
@NoArgsConstructor
public class PeriodForDate {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  private LocalTime startTime;

  private LocalTime endTime;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  private ScheduleForDate scheduleForDate;
}
