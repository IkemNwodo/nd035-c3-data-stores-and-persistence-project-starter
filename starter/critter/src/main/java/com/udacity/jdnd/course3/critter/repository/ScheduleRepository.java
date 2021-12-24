package com.udacity.jdnd.course3.critter.repository;

import com.udacity.jdnd.course3.critter.model.Schedule;

import java.util.List;

public interface ScheduleRepository {
    Schedule createSchedule(Schedule schedule);
    List<Schedule> getAllSchedules();
    List<Schedule> getScheduleForEmployee(long employeeId);
    List<Schedule> getScheduleForCustomer(long customerId);
    List<Schedule> getScheduleForPet(long petId);
}
