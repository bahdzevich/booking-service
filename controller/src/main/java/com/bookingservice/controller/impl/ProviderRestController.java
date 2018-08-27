package com.bookingservice.controller.impl;

import com.bookingservice.controller.AbstractCrudRestController;
import com.bookingservice.model.domain.Provider;
import com.bookingservice.service.IProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/provider", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ProviderRestController
    extends AbstractCrudRestController<Provider, Provider, Long, IProviderService> {

  @Autowired
  public ProviderRestController(IProviderService service) {
    super(service);
  }
}
