package org.example.demo_sp_th_2025.modelo;

import java.util.Objects;

public class Cliente {
    private int id;
    private String nombre;
    private String apellido;
    private String apellido2;
    private int categoria;

    public Cliente(int id, String nombre, String apellido, String apellido2, int categoria) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.apellido2 = apellido2;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getApellido2() {
        return apellido2;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return id == cliente.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", apellido2='" + apellido2 + '\'' +
                ", categoria=" + categoria +
                '}';
    }
}
