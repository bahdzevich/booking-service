package com.bookingservice.service.impl;

import com.bookingservice.model.domain.Admin;
import com.bookingservice.repository.AdminRepository;
import com.bookingservice.service.IAdminService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements IAdminService {

  private AdminRepository adminRepository;

  @Autowired
  public AdminServiceImpl(AdminRepository adminRepository) {
    this.adminRepository = adminRepository;
  }

  @Override
  public Admin create(Admin admin) {
    return null;
  }

  @Override
  public Optional<Admin> findOne(Long aLong) {
    return Optional.empty();
  }

  @Override
  public List<Admin> findAll() {
    return null;
  }

  @Override
  public Page<Admin> findPage(Integer page, Integer size) {
    return null;
  }

  @Override
  public Optional<Admin> update(Long aLong, Admin admin) {
    return Optional.empty();
  }

  @Override
  public Optional<Admin> delete(Long aLong) {
    return Optional.empty();
  }
}
