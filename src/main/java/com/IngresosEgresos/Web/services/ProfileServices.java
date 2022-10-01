package com.IngresosEgresos.Web.services;

import com.IngresosEgresos.Web.entities.Perfil;
import com.IngresosEgresos.Web.repositories.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileServices {
    private ProfileRepository repository;

    public ProfileServices(ProfileRepository repository) {
        this.repository = repository;
    }

    public List<Perfil> consultarPerfiles()
    {
        return this.repository.findAll();
        //return "hola";
    }
    public Optional<Perfil> consultarUnPerfil(long id)
    {
        return this.repository.findById(id);
        //return "mundo";
    }
    public Perfil crearPerfil(Perfil newReg)
    {
        // return this.repository.
        return this.repository.save(newReg);
        //return "mundo";
    }

    public String editarUnPerfil(long id)
    {
//return this.repositor
        return "mundo";
    }

    public void eliminarUnPerfil(long id)
    {
        this.repository.deleteById(id);
        //return "mundo";
    }

}
