package com.bookingservice.service.impl;

import com.bookingservice.model.domain.PeriodForDate;
import com.bookingservice.repository.PeriodForDateRepository;
import com.bookingservice.service.IPeriodForDateService;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
public class PeriodForDateServiceImpl implements IPeriodForDateService {

  private PeriodForDateRepository periodForDateRepository;

  @Autowired
  public PeriodForDateServiceImpl(
      PeriodForDateRepository periodForDateRepository) {
    this.periodForDateRepository = periodForDateRepository;
  }

  @Override
  public PeriodForDate create(final PeriodForDate periodForDate) {
    Assert.notNull(periodForDate, "Period for date is null.");
    return periodForDateRepository.save(periodForDate);
  }

  @Override
  public Optional<PeriodForDate> findOne(final Long id) {
    Assert.notNull(id, "Period for date id is null.");
    return periodForDateRepository.findById(id);
  }

  @Override
  public List<PeriodForDate> findAll() {
    return periodForDateRepository.findAll();
  }

  @Override
  public Page<PeriodForDate> findPage(final Integer page, final Integer size) {
    Assert.notNull(page, "Page number is null.");
    Assert.notNull(size, "Page size is null.");
    return periodForDateRepository.findAll(PageRequest.of(page, size));
  }

  @Override
  @Transactional
  public Optional<PeriodForDate> update(final Long id, final PeriodForDate periodForDate) {
    Assert.notNull(id, "Period for date id is null.");
    Assert.notNull(periodForDate, "Period for date is null.");
    return periodForDateRepository.findById(id).map(updatePeriodForDate(periodForDate));
  }

  @Override
  @Transactional
  public Optional<PeriodForDate> delete(final Long id) {
    Assert.notNull(id, "Period for date id is null.");
    Optional<PeriodForDate> periodForDateOptional = periodForDateRepository.findById(id);
    periodForDateOptional.ifPresent(periodForDateRepository::delete);
    return periodForDateOptional;
  }

  private Function<PeriodForDate, PeriodForDate> updatePeriodForDate(
      PeriodForDate updatedPeriodForDate) {
    return (persistedPeriodForDate) -> {
      persistedPeriodForDate.setStartTime(updatedPeriodForDate.getStartTime());
      persistedPeriodForDate.setEndTime(updatedPeriodForDate.getEndTime());
      return persistedPeriodForDate;
    };
  }
}
