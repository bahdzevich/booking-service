package com.bookingservice.model.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

/** A class for a client account. A client account is used to manage it's {@link Reservation}. */
@Entity
@Table(name = "CLIENT")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Client extends User {

  @OneToMany(mappedBy = "client")
  private Set<Reservation> reservations;
}
