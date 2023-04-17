package model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nombre, direccion;
    private long telefono;
    private List<Mascota> mascotas = new ArrayList<>();

    public Cliente(String nombre, String direccion, long telefono, List<Mascota> mascotas) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.mascotas = mascotas;
    }

    public Cliente(String nombre, String direccion, long telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public List<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono=" + telefono +
                ", mascotas=" + mascotas +
                '}';
    }

    public void addMascota(Mascota mascota){
        mascotas.add(mascota);
    }

    public double calcularPrecioCliente() {
        double precioTotal = 0;
        for (Mascota mascota : mascotas) {
            precioTotal += mascota.calcularPrecioMascota();
        }
        return precioTotal;
    }
}
