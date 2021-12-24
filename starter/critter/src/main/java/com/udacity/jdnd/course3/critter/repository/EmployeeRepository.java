package com.udacity.jdnd.course3.critter.repository;

import com.udacity.jdnd.course3.critter.model.Employees;
import com.udacity.jdnd.course3.critter.user.*;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;

public interface EmployeeRepository {
    Employees addEmployee(Employees employee);
    List<Employees> getAllEmployees();
    Employees findEmployeeById(Long id);
    void setAvailability (Set<DayOfWeek> availability, Long id);
    List<Employees> getEmployeesForService(Set<EmployeeSkill> skills, DayOfWeek dayOfWeek);
}

