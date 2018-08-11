package com.bookingservice.model.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

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

  @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Provider> providers;
}
