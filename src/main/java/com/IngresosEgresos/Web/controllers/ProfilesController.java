package com.IngresosEgresos.Web.controllers;

import com.IngresosEgresos.Web.entities.Perfil;
import com.IngresosEgresos.Web.services.ProfileServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



@CrossOrigin(origins = {"http://localhost:8080", "https://ingresosegresos2022.herokuapp.com"})
@RestController
public class ProfilesController {
        ProfileServices service;
    public ProfilesController(ProfileServices service) {
        this.service = service;
    }

    @GetMapping("/profilers")
    public List<Perfil> consultarPerfiles()
    {
        return this.service.consultarPerfiles();
        //return "200";
    }

    @PostMapping("/profilers")
    public Perfil CrearProfiler(@RequestBody Perfil pPerfil)
    {
        return this.service.crearPerfil(pPerfil);
        //return "200";
    }

    @GetMapping("/profile/{id}")
    public Optional<Perfil> ProfileList(@PathVariable long id)
    {
        return this.service.consultarUnPerfil(id);
        //return "200";
    }
    @PatchMapping("/profile/{id}")
    public Optional<Perfil> ProfileList2(@PathVariable long id)
    {
        return this.service.consultarUnPerfil(id);
        //return "200";
    }

    @DeleteMapping("/profile/{id}")
    public String borrarProfile(@PathVariable long id)
    {
        this.service.eliminarUnPerfil(id);
        return "200";
    }
}

