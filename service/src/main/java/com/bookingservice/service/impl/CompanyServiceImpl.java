package com.bookingservice.service.impl;

import com.bookingservice.model.domain.Company;
import com.bookingservice.repository.CompanyRepository;
import com.bookingservice.service.ICompanyService;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
public class CompanyServiceImpl implements ICompanyService {

  private final CompanyRepository companyRepository;

  @Autowired
  public CompanyServiceImpl(CompanyRepository companyRepository) {
    this.companyRepository = companyRepository;
  }

  @Override
  public Company create(final Company company) {
    Assert.notNull(company, "Company is null.");
    return companyRepository.save(company);
  }

  @Override
  public Optional<Company> findOne(final Long id) {
    Assert.notNull(id, "Company id is null.");
    return companyRepository.findById(id);
  }

  @Override
  public List<Company> findAll() {
    return companyRepository.findAll();
  }

  @Override
  public Page<Company> findPage(final Integer page, final Integer size) {
    Assert.notNull(page, "Page number is null.");
    Assert.notNull(size, "Page size is null.");
    return companyRepository.findAll(PageRequest.of(page, size));
  }

  @Override
  @Transactional
  public Optional<Company> update(final Long id, final Company company) {
    Assert.notNull(id, "Company id is null.");
    Assert.notNull(company, "Company is null.");
    return companyRepository.findById(id).map(updateCompany(company));
  }

  @Override
  @Transactional
  public Optional<Company> delete(final Long id) {
    Assert.notNull(id, "Admin id is null.");
    Optional<Company> companyOptional = companyRepository.findById(id);
    companyOptional.ifPresent(companyRepository::delete);
    return companyOptional;
  }

  private Function<Company, Company> updateCompany(Company updatedCompany) {
    return (persistedCompany) -> {
      persistedCompany.setEmail(updatedCompany.getEmail());
      persistedCompany.setName(updatedCompany.getName());
      persistedCompany.setPhone(updatedCompany.getPhone());
      persistedCompany.setDescription(updatedCompany.getDescription());
      return persistedCompany;
    };
  }
}
