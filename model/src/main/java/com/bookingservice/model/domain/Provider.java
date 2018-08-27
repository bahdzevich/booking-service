package com.bookingservice.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  private Company company;

  @JsonIgnore
  @ManyToMany(mappedBy = "providers")
  private Set<Service> services = new HashSet<>();

  @JsonIgnore
  @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<ScheduleForDate> scheduleForDateSet = new HashSet<>();

  @JsonIgnore
  @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<ScheduleForDay> scheduleForDaySet = new HashSet<>();

  @JsonIgnore
  @OneToMany(mappedBy = "provider")
  private Set<Reservation> reservationSet = new HashSet<>();
}
