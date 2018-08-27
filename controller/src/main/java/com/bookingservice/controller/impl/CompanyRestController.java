package com.bookingservice.controller.impl;

import com.bookingservice.controller.AbstractCrudRestController;
import com.bookingservice.model.domain.Company;
import com.bookingservice.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/company", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CompanyRestController
    extends AbstractCrudRestController<Company, Company, Long, ICompanyService> {

  @Autowired
  public CompanyRestController(ICompanyService service) {
    super(service);
  }
}
