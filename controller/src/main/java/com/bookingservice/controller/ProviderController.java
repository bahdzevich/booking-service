package com.bookingservice.controller;

import com.bookingservice.model.domain.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/provider", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ProviderController implements IBaseController<Provider, Provider, Long>{
    @Autowired
    ProviderServiceImpl providerServiceImpl;

    @PostMapping
    public ResponseEntity<Provider> create(@RequestBody Provider provider) {
        return new ResponseEntity<>(providerServiceImpl.create(provider), HttpStatus.CREATED);
    }

    @GetMapping("/{id:[0-9]+}")
    @Override
    public ResponseEntity<Provider> findOne(@PathVariable Long id) {
        return providerServiceImpl.findOne(id).map(provider -> new ResponseEntity<>(provider, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    @Override
    public ResponseEntity<List<Provider>> findAll() {
        return new ResponseEntity<>(providerServiceImpl.findAll(), HttpStatus.OK);
    }

    @PutMapping("/{id:[0-9]+}")
    @Override
    public ResponseEntity<Provider> update(@PathVariable Long id, @RequestBody Provider provider) {
        return providerServiceImpl.update(id, provider)
                .map(updatedProvider -> new ResponseEntity<>(updatedProvider, HttpStatus.OK))
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
    public ResponseEntity<Provider> delete(@PathVariable Long id) {
        return providerServiceImpl.delete(id)
                .map(provider -> new ResponseEntity<>(provider, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
