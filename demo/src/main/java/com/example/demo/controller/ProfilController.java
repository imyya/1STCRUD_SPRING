package com.example.demo.controller;
import com.example.demo.exception.ResourceNotFound;

import com.example.demo.model.Profil;
import com.example.demo.service.ProfilService;
import org.hibernate.annotations.AnyDiscriminator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class ProfilController {
    @Autowired
    private ProfilService  ProfilService;

    @GetMapping("/profils")

    public List<Profil> getAllProfils(){
        return ProfilService.getAllProfil();
    }

    @GetMapping(value = "/profils/{id}")

    public Profil getProfilById(@PathVariable("id") Long Id){
        Profil profil = ProfilService.getProfil(Id) .orElseThrow(()->new ResourceNotFound("Profil id "+Id+"not found"));
        return  profil;
    }

    @PostMapping("/profils")

    public String CreateProfil(@RequestBody Profil profil){
        ProfilService.save(profil);
        return "profil created with success!";
    }

    @PutMapping("profils/{id}")
    public Profil UpdateProfil(@PathVariable("id") Long Id, @RequestBody Profil profil ){
        return ProfilService.getProfil(Id).map(p->{
            p.setCode(profil.getCode());
            p.setLibelle(profil.getLibelle());
           return  ProfilService.save(p);
        }).orElseThrow(()->new ResourceNotFound("Le profil de cet id"+Id+"introuvable"));


    }







}
