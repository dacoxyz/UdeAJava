package com.IngresosEgresos.Web.controllers;

import com.IngresosEgresos.Web.entities.Empresa;
import com.IngresosEgresos.Web.services.EnterpriseServices;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:8080", "https://ingresosegresos2022.herokuapp.com"})
@Controller
public class FrontEnterpriseControllers {
    EnterpriseServices serviceEnterprise;


    public FrontEnterpriseControllers(EnterpriseServices service) {
        this.serviceEnterprise = service;
    }

    @GetMapping("/")
    public String index(Model model, @AuthenticationPrincipal OidcUser principal)
    {
        return  "index";
    }

    @GetMapping("/empresas")
    public String enterprises(Model pModel)
    {
        List<Empresa> Empresas=  this.serviceEnterprise.consultarEmpresas();
        pModel.addAttribute("Empresas",Empresas);
        return  "enterprises";
    }

    @GetMapping("/empresas/new")
    public String newEmpresa(Model pModel)
    {
        pModel.addAttribute("empresa",new Empresa());
        return "new-enterprise";

    }

}
