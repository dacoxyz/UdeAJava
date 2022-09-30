package com.IngresosEgresos.Web.repositories;
import com.IngresosEgresos.Web.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnterpriseRepository extends JpaRepository<Empresa, Long>{
}
//public interface EnterpriseRepository extends CrudRepository<Empresa, Long> {
//
//}
