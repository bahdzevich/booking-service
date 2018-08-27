package com.bookingservice.controller.impl;

import com.bookingservice.controller.AbstractCrudRestController;
import com.bookingservice.model.domain.Client;
import com.bookingservice.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/client", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ClientRestController
    extends AbstractCrudRestController<Client, Client, Long, IClientService> {

  @Autowired
  public ClientRestController(IClientService service) {
    super(service);
  }
}
