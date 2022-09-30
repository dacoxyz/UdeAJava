package com.IngresosEgresos.Web.services;

import com.IngresosEgresos.Web.ResourceNotFoundException;
import com.IngresosEgresos.Web.entities.Empresa;
import com.IngresosEgresos.Web.repositories.EnterpriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;

@Service
public class EnterpriseServices {
    //El sistema permite consultar todas las empresas
    //El sistema permite consultar una sola empresa
    //El sistema permite crear una empresa
    //El sistema permite editar una empresa
    //El sistema permite eliminar una empresa
    @Autowired
    private EnterpriseRepository repository;

    public EnterpriseServices(EnterpriseRepository repository) {
        this.repository = repository;
    }

    public List<Empresa> consultarEmpresas()
    {
        return (List<Empresa>) this.repository.findAll();
        //return "hola";
    }
    public Optional<Empresa> consultarUnaEmpresa(long id)
    {
        return this.repository.findById(id);
        //return "mundo";
    }
    public Empresa crearEmpresa(Empresa newEmpresa)
    {
       // return this.repository.
        return this.repository.save(newEmpresa);
        //return "mundo";
    }



   // public String editarUnaEmpresa(long id)
    //{
//return this.repositor
     //   return "mundo";
    //}
    public ResponseEntity<Empresa> updateEnterprise(@PathVariable Long id, @RequestBody Empresa enterpriseDetails){
        Empresa enterprise = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

        enterprise.setName(enterpriseDetails.getName());
        enterprise.setAddress(enterpriseDetails.getAddress());
        enterprise.setPhone(enterpriseDetails.getPhone());
        enterprise.setDocument(enterpriseDetails.getDocument());

        Empresa updatedEnterprise = repository.save(enterprise);
        return ResponseEntity.ok(updatedEnterprise);
    }



    public boolean eliminarUnaEmpresa(long id)
    {
        boolean bandera=true;
        Empresa auxEmpresa=repository.findById(id).orElse(null);
        //this.repository.deleteById(id);
        if(auxEmpresa==null){
            bandera=false;
        }else{
            repository.deleteById(id);
        }

        return bandera;
        //return "mundo";
    }

}
