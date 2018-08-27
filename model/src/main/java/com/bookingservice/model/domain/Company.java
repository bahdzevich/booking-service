package com.bookingservice.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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

  @JsonIgnore
  @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Provider> providers = new HashSet<>();

  @JsonIgnore
  @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Service> services = new HashSet<>();
}
