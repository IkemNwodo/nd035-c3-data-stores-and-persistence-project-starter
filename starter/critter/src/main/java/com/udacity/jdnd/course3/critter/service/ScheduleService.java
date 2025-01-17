package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.model.Schedule;
import com.udacity.jdnd.course3.critter.repository.CustomerJPARepository;
import com.udacity.jdnd.course3.critter.repository.ScheduleJPARepository;
import com.udacity.jdnd.course3.critter.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ScheduleService implements ScheduleRepository {


    ScheduleJPARepository scheduleRepo;
    CustomerJPARepository customerRepo;

    /**
     *
     * @param scheduleRepo
     * @param customerRepo
     */
    public ScheduleService(ScheduleJPARepository scheduleRepo, CustomerJPARepository customerRepo) {
        this.customerRepo = customerRepo;
        this.scheduleRepo = scheduleRepo;
    }

    /**
     *
     * @param schedule
     * @return saved schedule
     */
    @Override
    public Schedule createSchedule(Schedule schedule) {
        return scheduleRepo.save(schedule);
    }

    /**
     *
     * @return List of Schedule
     */
    @Override
    public List<Schedule> getAllSchedules() {
        return scheduleRepo.findAll();
    }

    /**
     *
     * @param employeeId
     * @return
     */
    @Override
    public List<Schedule> getScheduleForEmployee(long employeeId) {
        return scheduleRepo.findAllByEmployees_Id(employeeId);
    }

    /**
     *
     * @param customerId
     * @return
     */
    @Override
    public List<Schedule> getScheduleForCustomer(long customerId) {
        return scheduleRepo.findAllByCustomerId(customerId);


    }

    @Override
    public List<Schedule> getScheduleForPet(long petId) {
        return scheduleRepo.findAllByPets_Id(petId);
    }
}
