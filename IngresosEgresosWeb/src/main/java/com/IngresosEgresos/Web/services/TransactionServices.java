package com.IngresosEgresos.Web.services;

import com.IngresosEgresos.Web.entities.Empleado;
import com.IngresosEgresos.Web.entities.MovimientoDinero;
import com.IngresosEgresos.Web.repositories.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServices {
    private TransactionRepository repository;

    public TransactionServices(TransactionRepository repository) {
        this.repository = repository;
    }

    public List<MovimientoDinero> consultarTransactions()
    {
        return (List<MovimientoDinero>) this.repository.findAll();
        //return "hola";
    }
    public Optional<MovimientoDinero> consultarUnTransaction(long id)
    {
        return this.repository.findById(id);
        //return "mundo";
    }
    public MovimientoDinero crearTransaction(MovimientoDinero newReg)
    {
        // return this.repository.
        return this.repository.save(newReg);
        //return "mundo";
    }

    public String editarUnTransaction(long id)
    {
    //return this.repositor
        return "mundo";
    }

    public void eliminarUnTransaction(long id)
    {
        this.repository.deleteById(id);
        //return "mundo";
    }
}
