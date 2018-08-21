package com.bookingservice.service.impl;

import com.bookingservice.model.domain.Provider;
import com.bookingservice.repository.ProviderRepository;
import com.bookingservice.service.IProviderService;
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
public class ProviderServiceImpl implements IProviderService {

  private final ProviderRepository providerRepository;

  @Autowired
  public ProviderServiceImpl(ProviderRepository providerRepository) {
    this.providerRepository = providerRepository;
  }

  @Override
  public Provider create(final Provider provider) {
    return providerRepository.save(provider);
  }

  @Override
  public Optional<Provider> findOne(final Long id) {
    Assert.notNull(id, "Provider ID is null");
    return providerRepository.findById(id);
  }

  @Override
  public List<Provider> findAll() {
    return providerRepository.findAll();
  }

  @Override
  public Page<Provider> findPage(final Integer page, final Integer size) {
    Assert.notNull(page, "Page is null");
    Assert.notNull(size, "Size is null");
    return providerRepository.findAll(PageRequest.of(page, size));
  }

  @Override
  @Transactional
  public Optional<Provider> update(final Long id, final Provider provider) {
    Assert.notNull(id, "Provider ID is null");
    Assert.notNull(provider, "Provider is null");
    return providerRepository.findById(id).map(updateProvider(provider));
  }

  @Override
  @Transactional
  public Optional<Provider> delete(final Long id) {
    Assert.notNull(id, "Provider ID is null");
    Optional<Provider> providerOptional = providerRepository.findById(id);
    providerOptional.ifPresent(providerRepository::delete);
    return providerOptional;
  }

  private Function<Provider, Provider> updateProvider(Provider updatedProvider) {
    return (persistedProvider) -> {
      persistedProvider.setEmail(updatedProvider.getEmail());
      persistedProvider.setPhone(updatedProvider.getPhone());
      persistedProvider.setName(updatedProvider.getName());
      return persistedProvider;
    };
  }
}
