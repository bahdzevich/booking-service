package com.bookingservice.model.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

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

  @ManyToOne(fetch = FetchType.LAZY)
  private Client client;

  @ManyToOne(fetch = FetchType.LAZY)
  private Service service;

  @ManyToOne(fetch = FetchType.LAZY)
  private Provider provider;

  private String comment;
}
