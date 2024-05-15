package com.example.demo.service;

import com.example.demo.model.Profil;
import com.example.demo.repository.ProfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProfilService {
    @Autowired
    private ProfilRepository profilRepo;
    public List<Profil> getAllProfil(){
        Iterable<Profil> allIterables= profilRepo.findAll();
        return mapToList(allIterables);

        // Iterable<User> userIter=userRepos.findAll();
//       return StreamSupport.stream(userIter.spliterator(),false)
//               .map((user -> (User) user))
//               .collect(Collectors.toList());
    };

    private List<Profil> mapToList(Iterable<Profil> profils){
        List<Profil> profilsList= new ArrayList<>();
        for(Profil profil: profils ){
            profilsList.add(profil);
        }
        return profilsList;

    }

    public Optional<Profil> getProfil(Long id){
        return  profilRepo.findById(id);
    }

    public Profil save(Profil profil){
        return profilRepo.save(profil);
    }



}
