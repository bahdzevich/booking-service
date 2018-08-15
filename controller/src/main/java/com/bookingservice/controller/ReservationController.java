package com.bookingservice.controller;

import com.bookingservice.model.domain.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/reservation", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ReservationController implements IBaseController<Reservation, Reservation, Long> {
    @Autowired
    ReservationServiceImpl reservationServiceImpl;

    @PostMapping
    public ResponseEntity<Reservation> create(@RequestBody Reservation reservation) {
        return new ResponseEntity<>(reservationServiceImpl.create(reservation), HttpStatus.CREATED);
    }

    @GetMapping("/{id:[0-9]+}")
    @Override
    public ResponseEntity<Reservation> findOne(@PathVariable Long id) {
        return reservationServiceImpl.findOne(id).map(reservation -> new ResponseEntity<>(reservation, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    @Override
    public ResponseEntity<List<Reservation>> findAll() {
        return new ResponseEntity<>(reservationServiceImpl.findAll(), HttpStatus.OK);
    }

    @PutMapping("/{id:[0-9]+}")
    @Override
    public ResponseEntity<Reservation> update(@PathVariable Long id, @RequestBody Reservation reservation) {
        return reservationServiceImpl.update(id, reservation)
                .map(updatedReservation -> new ResponseEntity<>(updatedReservation, HttpStatus.OK))
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
    public ResponseEntity<Reservation> delete(@PathVariable Long id) {
        return reservationServiceImpl.delete(id)
                .map(reservation -> new ResponseEntity<>(reservation, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
