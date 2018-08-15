package com.bookingservice.controller;

import com.bookingservice.model.domain.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/client", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ClientController implements IBaseController<Client, Client, Long>{
    @Autowired
    ClientServiceImpl clientServiceImpl;

    @PostMapping
    public ResponseEntity<Client> create(@RequestBody Client client) {
        return new ResponseEntity<>(clientServiceImpl.create(client), HttpStatus.CREATED);
    }

    @GetMapping("/{id:[0-9]+}")
    @Override
    public ResponseEntity<Client> findOne(@PathVariable Long id) {
        return clientServiceImpl.findOne(id).map(client -> new ResponseEntity<>(client, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    @Override
    public ResponseEntity<List<Client>> findAll() {
        return new ResponseEntity<>(clientServiceImpl.findAll(), HttpStatus.OK);
    }

    @PutMapping("/{id:[0-9]+}")
    @Override
    public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client client) {
        return clientServiceImpl.update(id, client)
                .map(updatedClient -> new ResponseEntity<>(updatedClient, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

/*    @GetMapping
    @Override
    public ResponseEntity<List<ClientRespDto>> foundPage(
            @RequestParam(value = "page") Integer page,
            @RequestParam(value = "size") Integer size) {
        List<ClientRespDto> clientRespList = clientService.foundPage(page, size)
                .getContent();
        return new ResponseEntity<>(clientRespList, HttpStatus.OK);
    }*/

    @DeleteMapping("/{id:[0-9]+}")
    @Override
    public ResponseEntity<Client> delete(@PathVariable Long id) {
        return clientServiceImpl.delete(id)
                .map(client -> new ResponseEntity<>(client, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
