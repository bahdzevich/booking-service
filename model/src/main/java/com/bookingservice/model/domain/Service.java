package com.bookingservice.model.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Duration;
import java.util.Set;

/** A class represents a service that {@link Company} provides with. */
@Entity
@Table(name = "SERVICE")
@Data
@NoArgsConstructor
public class Service {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  private String name;

  private String description;

  /** Average time, needed for a {@link Provider} to complete a seance work. */
  private Duration duration;

  /** Max client quantity per seance */
  private int maxClientQuantity;

  @ManyToMany
  @JoinTable(
      name = "SVC_PVD",
      joinColumns = @JoinColumn(name = "svc_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "pvd_id", referencedColumnName = "id"))
  private Set<Provider> providers;
}
