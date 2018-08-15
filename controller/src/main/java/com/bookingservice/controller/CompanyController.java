package com.bookingservice.controller;

import com.bookingservice.model.domain.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/company", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CompanyController implements IBaseController<Company, Company, Long>{
    @Autowired
    CompanyServiceImpl companyServiceImpl;

    @PostMapping
    public ResponseEntity<Company> create(@RequestBody Company company) {
        return new ResponseEntity<>(companyServiceImpl.create(company), HttpStatus.CREATED);
    }

    @GetMapping("/{id:[0-9]+}")
    @Override
    public ResponseEntity<Company> findOne(@PathVariable Long id) {
        return companyServiceImpl.findOne(id).map(company -> new ResponseEntity<>(company, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    @Override
    public ResponseEntity<List<Company>> findAll() {
        return new ResponseEntity<>(companyServiceImpl.findAll(), HttpStatus.OK);
    }

    @PutMapping("/{id:[0-9]+}")
    @Override
    public ResponseEntity<Company> update(@PathVariable Long id, @RequestBody Company company) {
        return companyServiceImpl.update(id, company)
                .map(updatedCompany -> new ResponseEntity<>(updatedCompany, HttpStatus.OK))
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
    public ResponseEntity<Company> delete(@PathVariable Long id) {
        return companyServiceImpl.delete(id)
                .map(company -> new ResponseEntity<>(company, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
