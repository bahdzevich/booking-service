package com.bookingservice.controller.impl;

import com.bookingservice.controller.AbstractCrudRestController;
import com.bookingservice.model.domain.Service;
import com.bookingservice.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/service", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ServiceRestController
    extends AbstractCrudRestController<Service, Service, Long, IServiceService> {

  @Autowired
  public ServiceRestController(IServiceService service) {
    super(service);
  }
}
