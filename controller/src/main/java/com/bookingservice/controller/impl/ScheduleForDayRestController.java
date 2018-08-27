package com.bookingservice.controller.impl;

import com.bookingservice.controller.AbstractCrudRestController;
import com.bookingservice.model.domain.ScheduleForDay;
import com.bookingservice.service.IScheduleForDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/scheduleForDay", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ScheduleForDayRestController
    extends AbstractCrudRestController<
        ScheduleForDay, ScheduleForDay, Long, IScheduleForDayService> {

  @Autowired
  public ScheduleForDayRestController(IScheduleForDayService service) {
    super(service);
  }
}
