package com.example.demo.repository;

import com.example.demo.model.Profil;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProfilRepository extends CrudRepository<Profil,Long> {

//    Optional<Profil> findById(Long id);
}
