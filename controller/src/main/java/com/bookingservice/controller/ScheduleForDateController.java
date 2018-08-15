package com.bookingservice.controller;

import com.bookingservice.model.domain.ScheduleForDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/scheduleForDate", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ScheduleForDateController implements IBaseController<ScheduleForDate, ScheduleForDate, Long>{
    @Autowired
    ScheduleForDateServiceImpl scheduleForDayServiceImpl;

    @PostMapping
    public ResponseEntity<ScheduleForDate> create(@RequestBody ScheduleForDate scheduleForDate) {
        return new ResponseEntity<>(scheduleForDayServiceImpl.create(scheduleForDate), HttpStatus.CREATED);
    }

    @GetMapping("/{id:[0-9]+}")
    @Override
    public ResponseEntity<ScheduleForDate> findOne(@PathVariable Long id) {
        return scheduleForDayServiceImpl.findOne(id).map(scheduleForDate -> new ResponseEntity<>(scheduleForDate, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    @Override
    public ResponseEntity<List<ScheduleForDate>> findAll() {
        return new ResponseEntity<>(scheduleForDayServiceImpl.findAll(), HttpStatus.OK);
    }

    @PutMapping("/{id:[0-9]+}")
    @Override
    public ResponseEntity<ScheduleForDate> update(@PathVariable Long id, @RequestBody ScheduleForDate scheduleForDate) {
        return scheduleForDayServiceImpl.update(id, scheduleForDate)
                .map(updatedScheduleForDate -> new ResponseEntity<>(updatedScheduleForDate, HttpStatus.OK))
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
    public ResponseEntity<ScheduleForDate> delete(@PathVariable Long id) {
        return scheduleForDayServiceImpl.delete(id)
                .map(scheduleForDate -> new ResponseEntity<>(scheduleForDate, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
