package com.bookingservice.controller;

import com.bookingservice.model.domain.PeriodForDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/periodForDay", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PeriodForDayController implements IBaseController<PeriodForDay, PeriodForDay, Long>{
    @Autowired
    PeriodForDayService periodForDayService;

    @PostMapping
    public ResponseEntity<PeriodForDay> create(@RequestBody PeriodForDay periodForDay) {
        return new ResponseEntity<>(periodForDayService.create(periodForDay), HttpStatus.CREATED);
    }

    @GetMapping("/{id:[0-9]+}")
    @Override
    public ResponseEntity<PeriodForDay> findOne(@PathVariable Long id) {
        return periodForDayService.findOne(id).map(periodForDay -> new ResponseEntity<>(periodForDay, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    @Override
    public ResponseEntity<List<PeriodForDay>> findAll() {
        return new ResponseEntity<>(periodForDayService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/{id:[0-9]+}")
    @Override
    public ResponseEntity<PeriodForDay> update(@PathVariable Long id, @RequestBody PeriodForDay periodForDay) {
        return periodForDayService.update(id, periodForDay)
                .map(updatedPeriodForDay -> new ResponseEntity<>(updatedPeriodForDay, HttpStatus.OK))
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
    public ResponseEntity<PeriodForDay> delete(@PathVariable Long id) {
        return periodForDayService.delete(id)
                .map(periodForDay -> new ResponseEntity<>(periodForDay, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
