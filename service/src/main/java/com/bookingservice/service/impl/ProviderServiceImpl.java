package com.bookingservice.service.impl;

import com.bookingservice.model.domain.Provider;
import com.bookingservice.repository.ProviderRepository;
import com.bookingservice.service.IProviderService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class ProviderServiceImpl implements IProviderService {

  private ProviderRepository providerRepository;

  @Autowired
  public ProviderServiceImpl(ProviderRepository providerRepository) {
    this.providerRepository = providerRepository;
  }

  @Override
  public Provider create(Provider provider) {
    return null;
  }

  @Override
  public Optional<Provider> findOne(Long aLong) {
    return Optional.empty();
  }

  @Override
  public List<Provider> findAll() {
    return null;
  }

  @Override
  public Page<Provider> findPage(Integer page, Integer size) {
    return null;
  }

  @Override
  public Optional<Provider> update(Long aLong, Provider provider) {
    return Optional.empty();
  }

  @Override
  public Optional<Provider> delete(Long aLong) {
    return Optional.empty();
  }
}
