package com.IngresosEgresos.Web.controllers;

import com.IngresosEgresos.Web.entities.Empleado;
import com.IngresosEgresos.Web.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@CrossOrigin(origins = "http://localhost:8080")
@Controller
public class FrontUserControllers {
    @Autowired
    UserServices serviceUser;
    public FrontUserControllers(UserServices service) {
        this.serviceUser = service;
    }
//    @GetMapping("/")
//    public String index() {
//        return "index";
//    }

    @GetMapping("/users")
    public String users(Model pModel)
    {

        List<Empleado> Empleados=  this.serviceUser.consultarUsuarios();
        pModel.addAttribute("empleado",Empleados);

        return "usuarios";
    }
    @GetMapping("/users/new")
    public String newUser(Model pModel)
    {
        pModel.addAttribute("empleado", new Empleado());
        return "new-user";

    }
}
