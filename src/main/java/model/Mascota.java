package model;

import java.util.ArrayList;

public class Mascota {

    private String nombre;
    private int edad;
    private String tipo;
    private ArrayList<Servicio> servicios;

    public Mascota(String nombre, int edad, String tipo) {
        this.nombre = nombre;
        this.edad = edad;
        this.tipo = tipo;
        this.servicios = new ArrayList<Servicio>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(ArrayList<Servicio> servicios) {
        this.servicios = servicios;
    }

    @Override
    public String toString() {
        return "model.Mascota{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", tipo='" + tipo + '\'' +
                ", servicios=" + servicios +
                '}';
    }

    public void addService(Servicio servicio){
        servicios.add(servicio);
    }

    public double calcularPrecioMascota() {
        double precioTotal = 0;
        for (Servicio servicio : servicios) {
            precioTotal += servicio.getPrecio();
        }
        return precioTotal;
    }
}
