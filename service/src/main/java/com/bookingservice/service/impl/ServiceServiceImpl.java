package com.bookingservice.service.impl;

import com.bookingservice.model.domain.Service;
import com.bookingservice.repository.ServiceRepository;
import com.bookingservice.service.IServiceService;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.Assert;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements IServiceService {

  private ServiceRepository serviceRepository;

  public ServiceServiceImpl(ServiceRepository serviceRepository) {
    this.serviceRepository = serviceRepository;
  }

  @Override
  public Service create(Service service) {
    return serviceRepository.save(service);
  }

  @Override
  public Optional<Service> findOne(Long id) {
    Assert.notNull(id, "Service ID is null");
    return serviceRepository.findById(id);
  }

  @Override
  public List<Service> findAll() {
    return serviceRepository.findAll();
  }

  @Override
  public Page<Service> findPage(Integer page, Integer size) {
    Assert.notNull(page, "Page is null");
    Assert.notNull(size, "Size is null");
    return serviceRepository.findAll(PageRequest.of(page, size));
  }

  @Override
  public Optional<Service> update(Long id, Service service) {
    Assert.notNull(id, "Service ID is null");
    Assert.notNull(service, "Service is null");
    Service savedService = null;
    if (serviceRepository.existsById(id)) {
      savedService = serviceRepository.save(service);
    }
    return Optional.ofNullable(savedService);
  }

  @Override
  public Optional<Service> delete(Long id) {
    Assert.notNull(id, "Service ID is null");
    Optional<Service> service = serviceRepository.findById(id);
    if (service.isPresent()) {
      serviceRepository.deleteById(id);
    }
    return service;
  }
}
