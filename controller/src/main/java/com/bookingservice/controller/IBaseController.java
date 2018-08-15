package com.bookingservice.controller;

import org.springframework.http.ResponseEntity;

import java.io.Serializable;
import java.util.List;

public interface IBaseController<IN, OUT, PK extends Serializable> {
    ResponseEntity<OUT> create(IN in);
    ResponseEntity<OUT> findOne(PK pk);
    ResponseEntity<List<OUT>> findAll();
    //    ResponseEntity<List<OUT>> foundPage(Integer page, Integer size);
    ResponseEntity<OUT> update(PK pk, IN in);
    ResponseEntity<OUT> delete(PK pk);
}
