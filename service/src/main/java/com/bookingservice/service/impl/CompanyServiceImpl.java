package com.bookingservice.service.impl;

import com.bookingservice.model.domain.Company;
import com.bookingservice.repository.CompanyRepository;
import com.bookingservice.service.ICompanyService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements ICompanyService {

  private CompanyRepository companyRepository;

  @Autowired
  public CompanyServiceImpl(CompanyRepository companyRepository) {
    this.companyRepository = companyRepository;
  }

  @Override
  public Company create(Company company) {
    return null;
  }

  @Override
  public Optional<Company> findOne(Long aLong) {
    return Optional.empty();
  }

  @Override
  public List<Company> findAll() {
    return null;
  }

  @Override
  public Page<Company> findPage(Integer page, Integer size) {
    return null;
  }

  @Override
  public Optional<Company> update(Long aLong, Company company) {
    return Optional.empty();
  }

  @Override
  public Optional<Company> delete(Long aLong) {
    return Optional.empty();
  }
}
