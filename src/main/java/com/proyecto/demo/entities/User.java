package com.proyecto.demo.entities;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Date fechaN;
    private String correo;
    private String pwd;
    private String genero;
    private Date Created;

    @Transient
    private SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");

    //Constructores
    public User() {
    }

    public User(Long id, String name,Date fechaN, String correo, String pwd,String genero, Date date) throws ParseException {
        this.id = id;
        this.name = name;
        this.fechaN = fechaN;
        this.correo = correo;
        this.pwd = pwd;
        this.genero = genero;
        this.Created = format.parse(String.valueOf(date));
    }
    //GETTERS Y SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getFechaN() {
        return fechaN;
    }

    public void setFechaN(Date fechaN) {
        this.fechaN = fechaN;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getCreated() {
        return Created;
    }
    public void setCreated(Date created) {
        Created = created;
    }
    //
    public String getCreatedAsShort() {
        return format.format(Created);
    }

    public String toString() {
        StringBuilder value = new StringBuilder("UserEntry(");
        value.append("Id: ");
        value.append(id);
        value.append(",Nombre: ");
        value.append(name);
        value.append(",Fecha Nacimiento: ");
        value.append(fechaN);
        value.append(",Correo: ");
        value.append(correo);
        value.append(",contraseña: ");
        value.append(pwd);
        value.append(",Genero: ");
        value.append(genero);
        value.append(",Created: ");
        value.append(getCreatedAsShort());
        value.append(")");
        return value.toString();
    }

}
