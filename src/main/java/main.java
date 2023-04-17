import model.Cliente;
import model.Mascota;
import model.Servicio;
import model.Veterinaria;

import javax.swing.*;

public class main {

    public static void main(String[] args) {
        Veterinaria veterinaria = new Veterinaria();
        String opcion;

        do {
            opcion = JOptionPane.showInputDialog(
                    "Bienvenidos a la veterinaria Keycode, seleccione una opción:\n" +
                            "1. Agregar cliente\n" +
                            "2. Agregar mascota a un cliente\n" +
                            "3. Agregar servicio a una mascota\n" +
                            "4. Mostrar datos de un cliente\n" +
                            "5. Mostrar datos de una mascota\n" +
                            "6. Calcular precio total de servicios de un cliente\n" +
                            "7. Calcular precio total de servicios prestados por la veterinaria\n" +
                            "8. Salir"
            );

            switch (opcion) {
                case "1":
                    String nombreCliente = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
                    String direccionCliente = JOptionPane.showInputDialog("Ingrese la dirección del cliente:");
                    Long telefonoCliente = Long.parseLong(JOptionPane.showInputDialog("Ingrese el teléfono del cliente:"));

                    Cliente cliente = new Cliente(nombreCliente, direccionCliente, telefonoCliente);
                    veterinaria.addCliente(cliente);
                    break;

                case "2":
                    String clientname = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
                    Cliente client = veterinaria.buscarCliente(clientname);
                    String nombreMascota = JOptionPane.showInputDialog("Ingrese el nombre de la mascota:");
                    int edadMascota = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad de la mascota:"));
                    String tipoMascota = JOptionPane.showInputDialog("Ingrese el tipo de la mascota (ej: perro, gato, ave, etc.):");

                    Mascota mascota = new Mascota(nombreMascota, edadMascota, tipoMascota);
                    client.addMascota(mascota);
                    break;

                case "3":
                    String nombreCliente1 = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
                    String nombreMascota1 = JOptionPane.showInputDialog("Ingrese el nombre de la mascota:");

                    Cliente client1 = veterinaria.buscarCliente(nombreCliente1);

                    String tipoServicio = JOptionPane.showInputDialog("Ingrese el tipo de servicio:");
                    double precioServicio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del servicio:"));
                    Mascota mascota1 = veterinaria.buscarMascota(client1, nombreMascota1);
                    Servicio servicio = new Servicio(tipoServicio, precioServicio);
                    mascota1.addService(servicio);
                    break;

                case "4":
                    String nombreCliente2 = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
                    Cliente client2 = veterinaria.buscarCliente(nombreCliente2);
                    if (client2 == null) {
                        JOptionPane.showMessageDialog(null, "El cliente no fue encontrado");
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Cliente encontrado:\n");
                        sb.append("Nombre: " + client2.getNombre() + "\n");
                        sb.append("Dirección: " + client2.getDireccion() + "\n");
                        sb.append("Teléfono: " + client2.getTelefono() + "\n");
                        JOptionPane.showMessageDialog(null, sb);
                    }
                    break;

                case "5":
                    String nombreCliente3 = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
                    Cliente client3 = veterinaria.buscarCliente(nombreCliente3);
                    if (client3 == null) {
                        JOptionPane.showMessageDialog(null, "El cliente no existe");
                        break;
                    }
                    String nombreMascota2 = JOptionPane.showInputDialog("Ingrese el nombre de la mascota:");
                    Mascota mascota2 = veterinaria.buscarMascota(client3, nombreMascota2);
                    if (mascota2 == null) {
                        JOptionPane.showMessageDialog(null, "La mascota no fue encontrada para el cliente asociado");
                    } else {
                        StringBuilder sb1 = new StringBuilder();
                        sb1.append("Mascota encontrada:\n");
                        sb1.append("Nombre: " + mascota2.getNombre() + "\n");
                        sb1.append("Edad: " + mascota2.getEdad() + "\n");
                        sb1.append("Tipo: " + mascota2.getTipo() + "\n");
                        JOptionPane.showMessageDialog(null, sb1);
                    }
                    break;

                case "6":
                    String nombreCliente4 = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
                    Cliente client4 = veterinaria.buscarCliente(nombreCliente4);
                    if (client4 != null){
                        JOptionPane.showMessageDialog(null, client4.calcularPrecioCliente());
                    } else {
                        JOptionPane.showMessageDialog(null, "El cliente no existe");
                    }
                    break;
                case "7":
                    JOptionPane.showMessageDialog(null, "La ganancia total de la veterinaria el dia de hoy es " + veterinaria.calcularPrecioTotal());
                    break;
                case "8":
                    JOptionPane.showMessageDialog(null, "¡Gracias por visitar la Veterinaria Keycode!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Por favor seleccione una opción del menú.");
                    break;
            }
        } while (!opcion.equals("7"));
    }
}

