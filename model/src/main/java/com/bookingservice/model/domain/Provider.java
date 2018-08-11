package com.bookingservice.model.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

/**
 * A class for a provider account. A provider account is used to manage it's reservations. It is
 * also used to view information from the following entities: {@link ScheduleForDate}, {@link
 * PeriodForDate}, {@link ScheduleForDay}, {@link PeriodForDay}.
 */
@Entity
@Table(name = "PROVIDER")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Provider extends User {

  @ManyToMany(mappedBy = "providers")
  private Set<Service> services;

  @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<ScheduleForDate> scheduleForDateSet;

  @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<ScheduleForDay> scheduleForDaySet;

  @OneToMany(mappedBy = "provider")
  private Set<Reservation> reservationSet;
}
