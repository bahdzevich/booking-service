package com.bookingservice.model.domain;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

/** A class for an admin account. An admin account should have a top level of authority. */
@Entity
@Table(name = "ADMIN")
@NoArgsConstructor
public class Admin extends User {
}
