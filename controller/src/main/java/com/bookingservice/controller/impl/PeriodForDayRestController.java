package com.bookingservice.controller.impl;

import com.bookingservice.controller.AbstractCrudRestController;
import com.bookingservice.model.domain.PeriodForDay;
import com.bookingservice.service.IPeriodForDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/periodForDay", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PeriodForDayRestController
    extends AbstractCrudRestController<PeriodForDay, PeriodForDay, Long, IPeriodForDayService> {

  @Autowired
  public PeriodForDayRestController(IPeriodForDayService service) {
    super(service);
  }
}
