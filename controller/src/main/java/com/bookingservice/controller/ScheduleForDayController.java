package com.bookingservice.controller;

import com.bookingservice.model.domain.ScheduleForDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/scheduleForDay", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ScheduleForDayController implements IBaseController<ScheduleForDay, ScheduleForDay, Long> {
    @Autowired
    ScheduleForDayServiceImpl scheduleForDayServiceImpl;

    @PostMapping
    public ResponseEntity<ScheduleForDay> create(@RequestBody ScheduleForDay scheduleForDay) {
        return new ResponseEntity<>(scheduleForDayServiceImpl.create(scheduleForDay), HttpStatus.CREATED);
    }

    @GetMapping("/{id:[0-9]+}")
    @Override
    public ResponseEntity<ScheduleForDay> findOne(@PathVariable Long id) {
        return scheduleForDayServiceImpl.findOne(id).map(scheduleForDay -> new ResponseEntity<>(scheduleForDay, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    @Override
    public ResponseEntity<List<ScheduleForDay>> findAll() {
        return new ResponseEntity<>(scheduleForDayServiceImpl.findAll(), HttpStatus.OK);
    }

    @PutMapping("/{id:[0-9]+}")
    @Override
    public ResponseEntity<ScheduleForDay> update(@PathVariable Long id, @RequestBody ScheduleForDay scheduleForDay) {
        return scheduleForDayServiceImpl.update(id, scheduleForDay)
                .map(updatedScheduleForDay -> new ResponseEntity<>(updatedScheduleForDay, HttpStatus.OK))
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
    public ResponseEntity<ScheduleForDay> delete(@PathVariable Long id) {
        return scheduleForDayServiceImpl.delete(id)
                .map(scheduleForDay -> new ResponseEntity<>(scheduleForDay, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
