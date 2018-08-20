package com.bookingservice.service.impl;

import com.bookingservice.model.domain.PeriodForDay;
import com.bookingservice.repository.PeriodForDayRepository;
import com.bookingservice.service.IPeriodForDayService;
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
public class PeriodForDayServiceImpl implements IPeriodForDayService {

  private PeriodForDayRepository periodForDayRepository;

  @Autowired
  public PeriodForDayServiceImpl(PeriodForDayRepository periodForDayRepository) {
    this.periodForDayRepository = periodForDayRepository;
  }

  @Override
  public PeriodForDay create(final PeriodForDay periodForDay) {
    Assert.notNull(periodForDay, "Period for day is null.");
    return periodForDayRepository.save(periodForDay);
  }

  @Override
  public Optional<PeriodForDay> findOne(final Long id) {
    Assert.notNull(id, "Period for day id is null.");
    return periodForDayRepository.findById(id);
  }

  @Override
  public List<PeriodForDay> findAll() {
    return periodForDayRepository.findAll();
  }

  @Override
  public Page<PeriodForDay> findPage(final Integer page, final Integer size) {
    Assert.notNull(page, "Page number is null.");
    Assert.notNull(size, "Page size is null.");
    return periodForDayRepository.findAll(PageRequest.of(page, size));
  }

  @Override
  @Transactional
  public Optional<PeriodForDay> update(final Long id, final PeriodForDay periodForDay) {
    Assert.notNull(id, "Period for day id is null.");
    Assert.notNull(periodForDay, "Period for date is null.");
    return periodForDayRepository.findById(id).map(updatePeriodForDay(periodForDay));
  }

  @Override
  @Transactional
  public Optional<PeriodForDay> delete(final Long id) {
    Assert.notNull(id, "Period for day id is null.");
    Optional<PeriodForDay> periodForDateOptional = periodForDayRepository.findById(id);
    periodForDateOptional.ifPresent(periodForDayRepository::delete);
    return periodForDateOptional;
  }

  private Function<PeriodForDay, PeriodForDay> updatePeriodForDay(
      PeriodForDay updatedPeriodForDate) {
    return (persistedPeriodForDate) -> {
      persistedPeriodForDate.setStartTime(updatedPeriodForDate.getStartTime());
      persistedPeriodForDate.setEndTime(updatedPeriodForDate.getEndTime());
      return persistedPeriodForDate;
    };
  }
}
