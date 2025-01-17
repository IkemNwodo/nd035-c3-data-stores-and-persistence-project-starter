package com.udacity.jdnd.course3.critter.service;
import com.udacity.jdnd.course3.critter.user.*;

import com.udacity.jdnd.course3.critter.model.Employees;
import com.udacity.jdnd.course3.critter.repository.EmployeeJPARepository;
import com.udacity.jdnd.course3.critter.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class EmployeeService implements EmployeeRepository {


    EmployeeJPARepository employeeRepo;

    public EmployeeService(EmployeeJPARepository employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public Employees addEmployee(Employees employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public List<Employees> getAllEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public Employees findEmployeeById(Long id) {
        return  employeeRepo.getOne(id);
    }

    @Override
    public void setAvailability(Set<DayOfWeek> availability, Long id) {
        Employees employee = employeeRepo.getOne(id);

        if (employee.getId() != null) {
            employee.setDaysAvailable(availability);
            employeeRepo.save(employee);
        } else {
            throw new IllegalStateException("Employee not found");
        }

    }

    @Override
    public List<Employees> getEmployeesForService(Set<EmployeeSkill> skills, DayOfWeek dayOfWeek) {
        List<Employees> employees = new ArrayList<>();
        List<Employees> employeesAvailability = employeeRepo.findAllAvailability(dayOfWeek);

        employeesAvailability.forEach(employee->{
            if (employee.getSkills().containsAll(skills)) {
                employees.add(employee);
            }
        });

        return employees;
    }

}
