package com.bookingservice.model.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/** A base class for account definition in the project. */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
@NoArgsConstructor
public abstract class User {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  private String email;

  private String phone;

  private String secret;
}
