package com.bookingservice.service.impl;

import com.bookingservice.model.domain.Reservation;
import com.bookingservice.repository.ReservationRepository;
import com.bookingservice.service.IReservationService;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class ReservationServiceImpl implements IReservationService{

  private ReservationRepository reservationRepository;

  public ReservationServiceImpl(
      ReservationRepository reservationRepository) {
    this.reservationRepository = reservationRepository;
  }

  @Override
  public Reservation create(Reservation provider) {
    return reservationRepository.save(provider);
  }

  @Override
  public Optional<Reservation> findOne(Long id) {
    Assert.notNull(id, "Reservation ID is null");
    return reservationRepository.findById(id);
  }

  @Override
  public List<Reservation> findAll() {
    return reservationRepository.findAll();
  }

  @Override
  public Page<Reservation> findPage(Integer page, Integer size) {
    Assert.notNull(page, "Page is null");
    Assert.notNull(size, "Size is null");
    return reservationRepository.findAll(PageRequest.of(page, size));
  }

  @Override
  public Optional<Reservation> update(Long id, Reservation reservation) {
    Assert.notNull(id, "Reservation ID is null");
    Assert.notNull(reservation, "Reservation is null");
    Reservation savedReservation = null;
    if (reservationRepository.existsById(id)) {
      savedReservation = reservationRepository.save(reservation);
    }
    return Optional.ofNullable(savedReservation);
  }

  @Override
  public Optional<Reservation> delete(Long id) {
    Assert.notNull(id, "Provider ID is null");
    Optional<Reservation> reservation = reservationRepository.findById(id);
    if (reservation.isPresent()) {
      reservationRepository.deleteById(id);
    }
    return reservation;
  }
}
