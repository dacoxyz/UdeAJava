package com.IngresosEgresos.Web.entities;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Empleado")
public class Empleado{
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    @Column(name = "email")
    public String email;

    @Column(name = "nombre")
    public String nombre;
    @Column(name = "createdAt")
    public Date createdAt;
    @Column(name = "updatedAt")
    public Date updatedAt;

    @Column(name = "phone")
    public String phone;



    @Column(name = "idperfil")
    public long idperfil;

    //Basados en Clases
    /*
    Empresa enterprise;
    MovimientoDinero[] transactions;
    Enum_RoleName role;
    */

    //Constructor
    public Empleado()
    {

    }
    public Empleado(String email, String nombre,String phone)
    {
        this.email=email;
        this.nombre=nombre;
        this.phone=phone;
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    //Getters y Setters
    public long getIdperfil() {
        return idperfil;
    }

    public void setIdperfil(long idperfil) {
        this.idperfil = idperfil;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id=  id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email=  email;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone=  phone;
    }
}
