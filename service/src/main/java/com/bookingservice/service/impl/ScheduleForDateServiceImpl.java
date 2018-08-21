package com.bookingservice.service.impl;

import com.bookingservice.model.domain.ScheduleForDate;
import com.bookingservice.repository.ScheduleForDateRepository;
import com.bookingservice.service.IScheduleForDateService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class ScheduleForDateServiceImpl implements IScheduleForDateService {

  private ScheduleForDateRepository scheduleForDateRepository;

  @Autowired
  public ScheduleForDateServiceImpl(
      ScheduleForDateRepository scheduleForDateRepository) {
    this.scheduleForDateRepository = scheduleForDateRepository;
  }

  @Override
  public ScheduleForDate create(ScheduleForDate scheduleForDate) {
    return scheduleForDateRepository.save(scheduleForDate);
  }

  @Override
  public Optional<ScheduleForDate> findOne(Long id) {
    Assert.notNull(id, "ScheduleForDate ID is null");
    return scheduleForDateRepository.findById(id);
  }

  @Override
  public List<ScheduleForDate> findAll() {
    return scheduleForDateRepository.findAll();
  }

  @Override
  public Page<ScheduleForDate> findPage(Integer page, Integer size) {
    Assert.notNull(page, "Page is null");
    Assert.notNull(size, "Size is null");
    return scheduleForDateRepository.findAll(PageRequest.of(page, size));
  }

  @Override
  public Optional<ScheduleForDate> update(Long id, ScheduleForDate scheduleForDate) {
    Assert.notNull(id, "ScheduleForDate ID is null");
    Assert.notNull(scheduleForDate, "ScheduleForDate is null");
    ScheduleForDate savedScheduleForDate = null;
    if (scheduleForDateRepository.existsById(id)) {
      savedScheduleForDate = scheduleForDateRepository.save(scheduleForDate);
    }
    return Optional.ofNullable(savedScheduleForDate);
  }

  @Override
  public Optional<ScheduleForDate> delete(Long id) {
    Assert.notNull(id, "ScheduleForDate ID is null");
    Optional<ScheduleForDate> scheduleForDate = scheduleForDateRepository.findById(id);
    if (scheduleForDate.isPresent()) {
      scheduleForDateRepository.deleteById(id);
    }
    return scheduleForDate;
  }
}
