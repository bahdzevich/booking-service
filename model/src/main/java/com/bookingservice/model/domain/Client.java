package com.bookingservice.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/** A class for a client account. A client account is used to manage it's {@link Reservation}. */
@Entity
@Table(name = "CLIENT")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Client extends User {

  @JsonIgnore
  @OneToMany(mappedBy = "client")
  private Set<Reservation> reservations = new HashSet<>();
}
