package com.bookingservice.service.impl;

import com.bookingservice.model.domain.ScheduleForDay;
import com.bookingservice.repository.ScheduleForDayRepository;
import com.bookingservice.service.IScheduleForDayService;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class ScheduleForDayServiceImpl implements IScheduleForDayService{

  private ScheduleForDayRepository scheduleForDayRepository;

  public ScheduleForDayServiceImpl(
      ScheduleForDayRepository scheduleForDayRepository) {
    this.scheduleForDayRepository = scheduleForDayRepository;
  }

  @Override
  public ScheduleForDay create(ScheduleForDay scheduleForDay) {
    return scheduleForDayRepository.save(scheduleForDay);
  }

  @Override
  public Optional<ScheduleForDay> findOne(Long id) {
    Assert.notNull(id, "ScheduleForDay ID is null");
    return scheduleForDayRepository.findById(id);
  }

  @Override
  public List<ScheduleForDay> findAll() {
    return scheduleForDayRepository.findAll();
  }

  @Override
  public Page<ScheduleForDay> findPage(Integer page, Integer size) {
    Assert.notNull(page, "Page is null");
    Assert.notNull(size, "Size is null");
    return scheduleForDayRepository.findAll(PageRequest.of(page, size));
  }

  @Override
  public Optional<ScheduleForDay> update(Long id, ScheduleForDay scheduleForDay) {
    Assert.notNull(id, "ScheduleForDay ID is null");
    Assert.notNull(scheduleForDay, "ScheduleForDay is null");
    ScheduleForDay savedScheduleForDay = null;
    if (scheduleForDayRepository.existsById(id)) {
      savedScheduleForDay = scheduleForDayRepository.save(scheduleForDay);
    }
    return Optional.ofNullable(savedScheduleForDay);
  }

  @Override
  public Optional<ScheduleForDay> delete(Long id) {
    Assert.notNull(id, "ScheduleForDay ID is null");
    Optional<ScheduleForDay> scheduleForDay = scheduleForDayRepository.findById(id);
    if (scheduleForDay.isPresent()) {
      scheduleForDayRepository.deleteById(id);
    }
    return scheduleForDay;
  }
}
