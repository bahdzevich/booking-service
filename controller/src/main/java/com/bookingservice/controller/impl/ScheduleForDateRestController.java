package com.bookingservice.controller.impl;

import com.bookingservice.controller.AbstractCrudRestController;
import com.bookingservice.model.domain.ScheduleForDate;
import com.bookingservice.service.IScheduleForDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/scheduleForDate", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ScheduleForDateRestController
    extends AbstractCrudRestController<
        ScheduleForDate, ScheduleForDate, Long, IScheduleForDateService> {

  @Autowired
  public ScheduleForDateRestController(IScheduleForDateService service) {
    super(service);
  }
}
