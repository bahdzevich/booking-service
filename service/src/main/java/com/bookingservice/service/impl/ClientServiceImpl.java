package com.bookingservice.service.impl;

import com.bookingservice.model.domain.Client;
import com.bookingservice.repository.ClientRepository;
import com.bookingservice.service.IClientService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements IClientService {

  private ClientRepository clientRepository;

  @Autowired
  public ClientServiceImpl(ClientRepository clientRepository) {
    this.clientRepository = clientRepository;
  }

  @Override
  public Client create(Client client) {
    return null;
  }

  @Override
  public Optional<Client> findOne(Long aLong) {
    return Optional.empty();
  }

  @Override
  public List<Client> findAll() {
    return null;
  }

  @Override
  public Page<Client> findPage(Integer page, Integer size) {
    return null;
  }

  @Override
  public Optional<Client> update(Long aLong, Client client) {
    return Optional.empty();
  }

  @Override
  public Optional<Client> delete(Long aLong) {
    return Optional.empty();
  }
}
