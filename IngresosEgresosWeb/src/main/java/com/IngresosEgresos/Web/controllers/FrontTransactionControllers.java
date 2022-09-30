package com.IngresosEgresos.Web.controllers;

import com.IngresosEgresos.Web.entities.MovimientoDinero;
import com.IngresosEgresos.Web.services.TransactionServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@CrossOrigin(origins = "http://localhost:8080")
@Controller
public class FrontTransactionControllers {
    TransactionServices serviceTransaction;
    public FrontTransactionControllers(TransactionServices service) {
        this.serviceTransaction = service;
    }
    @GetMapping("/transacciones")
    public String transactions(Model pModel)
    {
        List<MovimientoDinero> Transactions=  this.serviceTransaction.consultarTransactions();
        pModel.addAttribute("Transacciones",Transactions);
        return  "transactions";
    }

    @GetMapping("/transacciones/new")
    public String newUser(Model pModel)
    {
        pModel.addAttribute("Transaccion",new MovimientoDinero());
        return "new-transaction";

    }

}
