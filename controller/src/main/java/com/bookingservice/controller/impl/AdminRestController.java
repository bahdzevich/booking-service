package com.bookingservice.controller.impl;

import com.bookingservice.controller.AbstractCrudRestController;
import com.bookingservice.model.domain.Admin;
import com.bookingservice.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AdminRestController
    extends AbstractCrudRestController<Admin, Admin, Long, IAdminService> {

  @Autowired
  public AdminRestController(IAdminService adminService) {
    super(adminService);
  }
}
