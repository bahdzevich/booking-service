package com.bookingservice.controller;

import com.bookingservice.model.domain.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/service", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ServiceController implements IBaseController<Service, Service, Long>{
    @Autowired
    ServiceServiceImpl serviceServiceImpl;

    @PostMapping
    public ResponseEntity<Service> create(@RequestBody Service service) {
        return new ResponseEntity<>(serviceServiceImpl.create(service), HttpStatus.CREATED);
    }

    @GetMapping("/{id:[0-9]+}")
    @Override
    public ResponseEntity<Service> findOne(@PathVariable Long id) {
        return serviceServiceImpl.findOne(id).map(service -> new ResponseEntity<>(service, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    @Override
    public ResponseEntity<List<Service>> findAll() {
        return new ResponseEntity<>(serviceServiceImpl.findAll(), HttpStatus.OK);
    }

    @PutMapping("/{id:[0-9]+}")
    @Override
    public ResponseEntity<Service> update(@PathVariable Long id, @RequestBody Service service) {
        return serviceServiceImpl.update(id, service)
                .map(updatedService -> new ResponseEntity<>(updatedService, HttpStatus.OK))
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
    public ResponseEntity<Service> delete(@PathVariable Long id) {
        return serviceServiceImpl.delete(id)
                .map(service -> new ResponseEntity<>(service, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
