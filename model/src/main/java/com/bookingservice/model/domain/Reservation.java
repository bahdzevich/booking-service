package com.bookingservice.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDate;
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

/**
 * The class describe a simple reservation made by {@link Client} for a particular time, {@link
 * Service} and {@link Provider}.
 */
@Entity
@Table(name = "RESERVATION")
@Data
@NoArgsConstructor
public class Reservation {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  private LocalDate localDate;

  private LocalTime localTime;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  private Client client;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  private Service service;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  private Provider provider;

  private String comment;
}
