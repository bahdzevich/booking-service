package com.bookingservice.service.impl;

import com.bookingservice.model.domain.ScheduleForDay;
import com.bookingservice.repository.ScheduleForDayRepository;
import com.bookingservice.service.IScheduleForDayService;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class ScheduleForDayServiceImpl implements IScheduleForDayService{

  private ScheduleForDayRepository scheduleForDayRepository;

  public ScheduleForDayServiceImpl(
      ScheduleForDayRepository scheduleForDayRepository) {
    this.scheduleForDayRepository = scheduleForDayRepository;
  }

  @Override
  public ScheduleForDay create(ScheduleForDay scheduleForDay) {
    return null;
  }

  @Override
  public Optional<ScheduleForDay> findOne(Long aLong) {
    return Optional.empty();
  }

  @Override
  public List<ScheduleForDay> findAll() {
    return null;
  }

  @Override
  public Page<ScheduleForDay> findPage(Integer page, Integer size) {
    return null;
  }

  @Override
  public Optional<ScheduleForDay> update(Long aLong, ScheduleForDay scheduleForDay) {
    return Optional.empty();
  }

  @Override
  public Optional<ScheduleForDay> delete(Long aLong) {
    return Optional.empty();
  }
}
