package com.IngresosEgresos.Web.controllers;
import com.IngresosEgresos.Web.entities.Empleado;
import com.IngresosEgresos.Web.entities.Empresa;
import com.IngresosEgresos.Web.services.EnterpriseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.constant.Constable;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
//import java.util.HashMap;
//import java.util.Map;
import com.IngresosEgresos.Web.repositories.EnterpriseRepository;
import org.springframework.web.servlet.view.RedirectView;


@CrossOrigin(origins = {"http://localhost:8080", "https://ingresosegresos2022.herokuapp.com"})
@RestController
public class EnterprisesController {
    @Autowired
    EnterpriseServices serviceEnterprise;

    public EnterprisesController(EnterpriseServices service) {
        this.serviceEnterprise = service;
    }

    @GetMapping("/enterprisesTest")
    public String EnterprisesListTest()
    {
         return "200";
    }
    @GetMapping("/enterprises")
    public List<Empresa> consultarEmpresas()
    {
    return this.serviceEnterprise.consultarEmpresas();
    //return 200;
    }

    @PostMapping("/AddEnterprises")
    public RedirectView CrearEnterprise(@ModelAttribute Empresa pEmpresa, Model pModel) //RequestBody type JSON
    {
        pModel.addAttribute(pEmpresa);
        this.serviceEnterprise.crearEmpresa(pEmpresa);
        return new RedirectView("/empresas");
        //return “200”;
    }

    @GetMapping("/enterprisesTest/{id}")
    public Constable String (@PathVariable long id)
    {
        return "200";
    }
    @GetMapping("/enterprises/{id}")
    public Optional<Empresa> EnterpriseList(@PathVariable long id)
    {
        return this.serviceEnterprise.consultarUnaEmpresa(id);
        //return 200;
    }
    @PatchMapping("/enterprises/{id}")
    public Optional<Empresa>  EnterpriseList1(@PathVariable long id)
    {
        return this.serviceEnterprise.consultarUnaEmpresa(id);
//        return 200;
    }

    @DeleteMapping("/enterprises/{id}")
    public RedirectView borrarEnterprise(@PathVariable ("id") long id)
    {
        this.serviceEnterprise.eliminarUnaEmpresa(id);
        return new RedirectView("/empresas");
    }

}
