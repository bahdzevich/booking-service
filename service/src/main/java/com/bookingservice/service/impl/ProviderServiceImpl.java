package com.bookingservice.service.impl;

import com.bookingservice.model.domain.Provider;
import com.bookingservice.repository.ProviderRepository;
import com.bookingservice.service.IProviderService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class ProviderServiceImpl implements IProviderService {

  private ProviderRepository providerRepository;

  @Autowired
  public ProviderServiceImpl(ProviderRepository providerRepository) {
    this.providerRepository = providerRepository;
  }

  @Override
  public Provider create(Provider provider) {
    return providerRepository.save(provider);
  }

  @Override
  public Optional<Provider> findOne(Long id) {
    Assert.notNull(id, "Provider ID is null");
    return providerRepository.findById(id);
  }

  @Override
  public List<Provider> findAll() {
    return providerRepository.findAll();
  }

  @Override
  public Page<Provider> findPage(Integer page, Integer size) {
    Assert.notNull(page, "Page is null");
    Assert.notNull(size, "Size is null");
    return providerRepository.findAll(PageRequest.of(page, size));
  }

  @Override
  public Optional<Provider> update(Long id, Provider provider) {
    Assert.notNull(id, "Provider ID is null");
    Assert.notNull(provider, "Provider is null");
    Provider savedClient = null;
    if (providerRepository.existsById(id)) {
      savedClient = providerRepository.save(provider);
    }
    return Optional.ofNullable(savedClient);
  }

  @Override
  public Optional<Provider> delete(Long id) {
    Assert.notNull(id, "Provider ID is null");
    Optional<Provider> provider = providerRepository.findById(id);
    if (provider.isPresent()) {
      providerRepository.deleteById(id);
    }
    return provider;
  }
}
