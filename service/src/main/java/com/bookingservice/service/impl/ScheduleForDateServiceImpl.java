package com.bookingservice.service.impl;

import com.bookingservice.model.domain.ScheduleForDate;
import com.bookingservice.repository.ScheduleForDateRepository;
import com.bookingservice.service.IScheduleForDateService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

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
    return null;
  }

  @Override
  public Optional<ScheduleForDate> findOne(Long aLong) {
    return Optional.empty();
  }

  @Override
  public List<ScheduleForDate> findAll() {
    return null;
  }

  @Override
  public Page<ScheduleForDate> findPage(Integer page, Integer size) {
    return null;
  }

  @Override
  public Optional<ScheduleForDate> update(Long aLong, ScheduleForDate scheduleForDate) {
    return Optional.empty();
  }

  @Override
  public Optional<ScheduleForDate> delete(Long aLong) {
    return Optional.empty();
  }
}
