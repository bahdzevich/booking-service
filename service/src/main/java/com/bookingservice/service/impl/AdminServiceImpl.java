package com.bookingservice.service.impl;

import com.bookingservice.model.domain.Admin;
import com.bookingservice.repository.AdminRepository;
import com.bookingservice.service.IAdminService;
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
public class AdminServiceImpl implements IAdminService {

  private final AdminRepository adminRepository;

  @Autowired
  public AdminServiceImpl(AdminRepository adminRepository) {
    this.adminRepository = adminRepository;
  }

  @Override
  public Admin create(final Admin admin) {
    Assert.notNull(admin, "Admin is null.");
    return adminRepository.save(admin);
  }

  @Override
  public Optional<Admin> findOne(final Long id) {
    Assert.notNull(id, "Admin id is null.");
    return adminRepository.findById(id);
  }

  @Override
  public List<Admin> findAll() {
    return adminRepository.findAll();
  }

  @Override
  public Page<Admin> findPage(final Integer page, final Integer size) {
    Assert.notNull(page, "Page number is null.");
    Assert.notNull(size, "Page size is null.");
    return adminRepository.findAll(PageRequest.of(page, size));
  }

  @Override
  @Transactional
  public Optional<Admin> update(final Long id, final Admin admin) {
    Assert.notNull(id, "Admin id is null.");
    Assert.notNull(admin, "Admin is null.");
    return adminRepository.findById(id).map(updateAdmin(admin));
  }

  @Override
  @Transactional
  public Optional<Admin> delete(final Long id) {
    Assert.notNull(id, "Admin id is null.");
    Optional<Admin> adminOptional = adminRepository.findById(id);
    adminOptional.ifPresent(adminRepository::delete);
    return adminOptional;
  }

  private Function<Admin, Admin> updateAdmin(final Admin updatedAdmin) {
    return (persistedAdmin) -> {
      persistedAdmin.setEmail(updatedAdmin.getEmail());
      persistedAdmin.setName(updatedAdmin.getName());
      persistedAdmin.setPhone(updatedAdmin.getPhone());
      return persistedAdmin; };
  }
}
