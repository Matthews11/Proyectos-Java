package org.administracion.models;


public class Rol {

    private Long id;


    private String rol;

    public Rol() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Rol: \n" +
                "id=" + id +
                ", rol ='" + rol ;
    }
}
