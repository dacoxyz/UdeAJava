package com.IngresosEgresos.Web.services;

import com.IngresosEgresos.Web.ResourceNotFoundException;
import com.IngresosEgresos.Web.entities.Empleado;
import com.IngresosEgresos.Web.repositories.EmployeeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {
    public EmployeeRepository repository;

    public UserServices(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<Empleado> consultarUsuarios()
    {
        return (List<Empleado>) this.repository.findAll();
        //return "hola";
    }
    public Optional<Empleado> consultarUnUsuario(long id)
    {
        return this.repository.findById(id);

        //return "mundo";
    }
    public Empleado crearUsuario(Empleado newEmpleado)
    {
        // return this.repository.
        return this.repository.save(newEmpleado);
        //return "mundo";
    }

    public Boolean editarUnUsuario(long id, String email, String Nombre,String phone)
    {
        Optional<Empleado> user = this.repository.findById(id);
        if (user.isPresent()){
            user.get().setEmail(email);
            user.get().setNombre(Nombre);
            user.get().setPhone(phone);
            this.repository.save(user.get());
            return true;
        }
        return false;
    }
    public ResponseEntity<Empleado> editarUnUsuario(@PathVariable Long id, @RequestBody Empleado empleadoDetails){
        Empleado user = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

        user.setNombre(empleadoDetails.getNombre());
        user.setEmail(empleadoDetails.getEmail());
        //user.setPhone(empleadoDetails.getPhone());
        //user.setDocument(empleadoDetails.getDocument());

        Empleado updatedEmpleado = repository.save(user);
        return ResponseEntity.ok(updatedEmpleado);
    }
    public boolean eliminarUnUsuario(long id)
    {
        this.repository.deleteById(id);
        return true;
        //return "mundo";
    }

}
