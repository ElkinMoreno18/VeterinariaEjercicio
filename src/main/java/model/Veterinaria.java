package model;

import java.util.ArrayList;
import java.util.List;

public class Veterinaria {

    private List<Cliente> clientes;

    public Veterinaria(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Veterinaria() {
        clientes = new ArrayList<>();
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }


    public void addCliente(Cliente cliente){
        clientes.add(cliente);
    }

    public Cliente buscarCliente(String nombre){
        for (Cliente cliente: clientes){
            if (cliente.getNombre().equals(nombre)) {
                return cliente;
            }
        }
        return null;
    }

    public Mascota buscarMascota(Cliente cliente, String nombre) {
        for (Mascota mascota : cliente.getMascotas()) {
            if (mascota.getNombre().equals(nombre)) {
                return mascota;
            }
        }
        return null;
    }

    public double calcularPrecioTotal() {
        double precioTotal = 0;
        for (Cliente cliente : clientes) {
            precioTotal += cliente.calcularPrecioCliente();
        }
        return precioTotal;
    }
}
