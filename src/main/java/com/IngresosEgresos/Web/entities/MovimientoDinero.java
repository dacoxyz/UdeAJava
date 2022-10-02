package com.IngresosEgresos.Web.entities;
import javax.persistence.*;
import java.util.Date;

//en el figma aparece como Transaction pero en el pdf se habla de entidades en español
@Entity
@Table(name="MovimientoDinero")
public class MovimientoDinero {

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    @Column(name = "concept")
    public String concept;
    @Column(name = "amount")
    public float amount;
    @Column(name = "createdAt")
    public  Date createdAt;



    @Column(name = "updatedAt")
    public Date updatedAt;

    //Basados en Clases
    /*
    Empleado user;
    Empresa enterprise;
   */

    //Constructor
    public MovimientoDinero()
    {

    }
    public MovimientoDinero(String concept, float amount)
    {
        this.concept=concept;
        this.amount=amount;
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    //Getters y Setters
    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id=  id;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept=  concept;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount=  amount;
    }

}

