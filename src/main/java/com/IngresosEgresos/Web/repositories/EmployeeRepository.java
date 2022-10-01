package com.IngresosEgresos.Web.repositories;
import com.IngresosEgresos.Web.entities.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Empleado, Long>{

}