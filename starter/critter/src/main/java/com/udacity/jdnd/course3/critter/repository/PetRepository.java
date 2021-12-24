package com.udacity.jdnd.course3.critter.repository;

import com.udacity.jdnd.course3.critter.model.Pet;

import java.util.List;

public interface PetRepository {

    Pet savePet(Pet pet);
    List<Pet> getAllPets();
    Pet getPet(long petId);
    List<Pet> getOwnerByPet(Long id);



}
