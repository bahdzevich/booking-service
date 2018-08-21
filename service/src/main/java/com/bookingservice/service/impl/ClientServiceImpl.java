package com.bookingservice.service.impl;

import com.bookingservice.model.domain.Client;
import com.bookingservice.repository.ClientRepository;
import com.bookingservice.service.IClientService;
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
public class ClientServiceImpl implements IClientService {

  private final ClientRepository clientRepository;

  @Autowired
  public ClientServiceImpl(ClientRepository clientRepository) {
    this.clientRepository = clientRepository;
  }

  @Override
  public Client create(final Client client) {
    Assert.notNull(client, "Client is null.");
    return clientRepository.save(client);
  }

  @Override
  public Optional<Client> findOne(final Long id) {
    Assert.notNull(id, "Client id is null.");
    return clientRepository.findById(id);
  }

  @Override
  public List<Client> findAll() {
    return clientRepository.findAll();
  }

  @Override
  public Page<Client> findPage(final Integer page, final Integer size) {
    Assert.notNull(page, "Page number is null.");
    Assert.notNull(size, "Page size is null.");
    return clientRepository.findAll(PageRequest.of(page, size));
  }

  @Override
  @Transactional
  public Optional<Client> update(final Long id, final Client client) {
    Assert.notNull(id, "Client id is null.");
    Assert.notNull(client, "Client is null.");
    return clientRepository.findById(id).map(updateClient(client));
  }

  @Override
  @Transactional
  public Optional<Client> delete(final Long id) {
    Assert.notNull(id, "Admin id is null.");
    Optional<Client> clientOptional = clientRepository.findById(id);
    clientOptional.ifPresent(clientRepository::delete);
    return clientOptional;
  }

  private Function<Client, Client> updateClient(final Client updatedClient) {
    return (persistedClient) -> {
      persistedClient.setEmail(updatedClient.getEmail());
      persistedClient.setName(updatedClient.getName());
      persistedClient.setPhone(updatedClient.getPhone());
      return persistedClient; };
  }
}
