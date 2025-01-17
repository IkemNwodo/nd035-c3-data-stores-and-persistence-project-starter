package com.udacity.jdnd.course3.critter.repository;

import com.udacity.jdnd.course3.critter.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ScheduleJPARepository extends JpaRepository<Schedule, Long> {

    List<Schedule> findAllByEmployees_Id(long id);
    List<Schedule> findAllByPets_Id(long id);

    @Query("SELECT s FROM Schedule s JOIN s.pets p JOIN p.owner o WHERE o.id=:id")
    List<Schedule> findAllByCustomerId(@Param("id") long id);
}
