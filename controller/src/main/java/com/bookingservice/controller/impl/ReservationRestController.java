package com.bookingservice.controller.impl;

import com.bookingservice.controller.AbstractCrudRestController;
import com.bookingservice.model.domain.Reservation;
import com.bookingservice.service.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/reservation", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ReservationRestController
    extends AbstractCrudRestController<Reservation, Reservation, Long, IReservationService> {

  @Autowired
  public ReservationRestController(IReservationService service) {
    super(service);
  }
}
