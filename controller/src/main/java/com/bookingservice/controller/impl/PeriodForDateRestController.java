package com.bookingservice.controller.impl;

import com.bookingservice.controller.AbstractCrudRestController;
import com.bookingservice.model.domain.PeriodForDate;
import com.bookingservice.service.IPeriodForDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/periodForDate", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PeriodForDateRestController
    extends AbstractCrudRestController<PeriodForDate, PeriodForDate, Long, IPeriodForDateService> {

  @Autowired
  public PeriodForDateRestController(IPeriodForDateService service) {
    super(service);
  }
}
