package com.udacity.jdnd.course3.critter.repository;

import com.udacity.jdnd.course3.critter.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface PetJPARepository extends JpaRepository<Pet, Long> {
    @Query("select p from Pet p where p.owner.id =:id")
    List<Pet> getOwnerByPet(Long id);

}
