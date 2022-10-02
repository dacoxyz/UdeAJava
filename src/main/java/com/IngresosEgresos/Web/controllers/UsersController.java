package com.IngresosEgresos.Web.controllers;

import com.IngresosEgresos.Web.entities.Empleado;
import com.IngresosEgresos.Web.services.UserServices;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@CrossOrigin(origins = {"http://localhost:8080", "https://ingresosegresos2022.herokuapp.com"})
@RestController
public class UsersController {

    //EnterpriseServices serviceEnterprise;
    UserServices serviceUser;
    public UsersController(UserServices service) {
        this.serviceUser = service;
    }

//    @GetMapping("/users")
//    public List<Empleado> consultarUsuarios()
//    {
//        return (List<Empleado>) this.serviceUser.consultarUsuarios();
//        //return “200“;
//    }
//@DateTimeFormat(pattern="YYYY-MM-DD")
    @PostMapping("/user")
    public RedirectView CrearEmployee(@ModelAttribute Empleado pEmpleado, Model pModel) //RequestBody type JSON
    {
        pModel.addAttribute(pEmpleado);
        this.serviceUser.crearUsuario(pEmpleado);
        return new RedirectView("/users");
        //return “200”;
    }

//    @GetMapping("/user/{id}")
//    public Optional<Empleado> EmployeeList(@PathVariable long id)
//    {
//        return this.serviceUser.consultarUnUsuario(id);
//        //return “200“;
//    }
    @PatchMapping("/user/{id}") //se actualiza un solo campo
    public RedirectView updEmployee(@PathVariable ("id") long id,@PathVariable("email") String email,@PathVariable("name") String name,@PathVariable("phone") String phone )
    {
         this.serviceUser.editarUnUsuario(id,email,name,phone);
        return new RedirectView("/users");
        //return “200“;
    }

    @PutMapping("/user/{id}")//se acutaliza todos los campos
    public RedirectView updEmployeeSll(@PathVariable ("id") long id,@PathVariable("email") String email,@PathVariable("name") String name,@PathVariable("phone") String phone )
    {
        this.serviceUser.editarUnUsuario(id,email,name,phone);
        return new RedirectView("/users");
        //return “200“;
    }
    @DeleteMapping("/user/{id}")
    public RedirectView borrarEmployee(@PathVariable ("id") long id)
    {
        this.serviceUser.eliminarUnUsuario(id);
        return new RedirectView("/users");
    }
}
