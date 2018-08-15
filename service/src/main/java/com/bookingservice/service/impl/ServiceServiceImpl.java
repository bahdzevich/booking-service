package com.bookingservice.service.impl;

import com.bookingservice.repository.ServiceRepository;
import com.bookingservice.service.IServiceService;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class ServiceServiceImpl implements IServiceService {

  private ServiceRepository serviceRepository;

  public ServiceServiceImpl(ServiceRepository serviceRepository) {
    this.serviceRepository = serviceRepository;
  }

  @Override
  public com.bookingservice.model.domain.Service create(
      com.bookingservice.model.domain.Service service) {
    return null;
  }

  @Override
  public Optional<com.bookingservice.model.domain.Service> findOne(Long aLong) {
    return Optional.empty();
  }

  @Override
  public List<com.bookingservice.model.domain.Service> findAll() {
    return null;
  }

  @Override
  public Page<com.bookingservice.model.domain.Service> findPage(Integer page, Integer size) {
    return null;
  }

  @Override
  public Optional<com.bookingservice.model.domain.Service> update(Long aLong,
      com.bookingservice.model.domain.Service service) {
    return Optional.empty();
  }

  @Override
  public Optional<com.bookingservice.model.domain.Service> delete(Long aLong) {
    return Optional.empty();
  }
}
