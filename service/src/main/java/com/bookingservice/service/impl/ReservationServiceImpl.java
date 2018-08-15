package com.bookingservice.service.impl;

import com.bookingservice.model.domain.Reservation;
import com.bookingservice.repository.ReservationRepository;
import com.bookingservice.service.IReservationService;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements IReservationService{

  private ReservationRepository reservationRepository;

  public ReservationServiceImpl(
      ReservationRepository reservationRepository) {
    this.reservationRepository = reservationRepository;
  }

  @Override
  public Reservation create(Reservation reservation) {
    return null;
  }

  @Override
  public Optional<Reservation> findOne(Long aLong) {
    return Optional.empty();
  }

  @Override
  public List<Reservation> findAll() {
    return null;
  }

  @Override
  public Page<Reservation> findPage(Integer page, Integer size) {
    return null;
  }

  @Override
  public Optional<Reservation> update(Long aLong, Reservation reservation) {
    return Optional.empty();
  }

  @Override
  public Optional<Reservation> delete(Long aLong) {
    return Optional.empty();
  }
}
