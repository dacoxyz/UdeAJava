package com.IngresosEgresos.Web.repositories;

import com.IngresosEgresos.Web.entities.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<MovimientoDinero, Long> {

}