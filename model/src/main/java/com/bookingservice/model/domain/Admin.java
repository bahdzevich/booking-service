package com.bookingservice.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.NoArgsConstructor;

/** A class for an admin account. An admin account should have a top level of authority. */
@Entity
@Table(name = "ADMIN")
@NoArgsConstructor
public class Admin extends User {}
