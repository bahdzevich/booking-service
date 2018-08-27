package com.bookingservice.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.Duration;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

/** A class represents a service that {@link Company} provides with. */
@Entity
@Table(name = "SERVICE")
@Data
@NoArgsConstructor
public class Service {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  private Company company;

  private String name;

  private String description;

  /** Average time, needed for a {@link Provider} to complete a seance work. */
  private Duration duration;

  /** Max client quantity per seance */
  private int maxClientQuantity;

  @JsonIgnore
  @ManyToMany
  @JoinTable(
      name = "SVC_PVD",
      joinColumns = @JoinColumn(name = "svc_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "pvd_id", referencedColumnName = "id"))
  private Set<Provider> providers = new HashSet<>();
}
