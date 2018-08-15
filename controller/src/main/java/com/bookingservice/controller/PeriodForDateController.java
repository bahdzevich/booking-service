package com.bookingservice.controller;

import com.bookingservice.model.domain.PeriodForDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/periodForDate", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PeriodForDateController implements IBaseController<PeriodForDate, PeriodForDate, Long>{
    @Autowired
    PeriodForDateService periodForDateService;

    @PostMapping
    public ResponseEntity<PeriodForDate> create(@RequestBody PeriodForDate periodForDate) {
        return new ResponseEntity<>(periodForDateService.create(periodForDate), HttpStatus.CREATED);
    }

    @GetMapping("/{id:[0-9]+}")
    @Override
    public ResponseEntity<PeriodForDate> findOne(@PathVariable Long id) {
        return periodForDateService.findOne(id).map(periodForDate -> new ResponseEntity<>(periodForDate, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    @Override
    public ResponseEntity<List<PeriodForDate>> findAll() {
        return new ResponseEntity<>(periodForDateService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/{id:[0-9]+}")
    @Override
    public ResponseEntity<PeriodForDate> update(@PathVariable Long id, @RequestBody PeriodForDate periodForDate) {
        return periodForDateService.update(id, periodForDate)
                .map(updatedPeriodForDate -> new ResponseEntity<>(updatedPeriodForDate, HttpStatus.OK))
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
    public ResponseEntity<PeriodForDate> delete(@PathVariable Long id) {
        return periodForDateService.delete(id)
                .map(periodForDate -> new ResponseEntity<>(periodForDate, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
