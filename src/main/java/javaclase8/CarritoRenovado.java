package javaclase8;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class CarritoRenovado {

    public static void main(String[] args) throws IOException {
        File archivo = new File("C:\\Users\\Manuel\\Documents\\NetBeansProjects\\JavaClase8\\src\\main\\java\\javaclase8\\carrito.txt");

        List<ItemCarrito> items = new ArrayList<>();
        int numeroCarrito = 1;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(" ");
                int cantidad = Integer.parseInt(datos[0]);
                int precioUnitario = Integer.parseInt(datos[1]);
                String nombreProducto = datos[2];
                Producto producto = new Producto(nombreProducto, precioUnitario);
                ItemCarrito item = new ItemCarrito(producto, cantidad);
                items.add(item);
            }
        } catch (IOException e) {
            System.out.println("error");
        }
        System.out.println("Bienvenido a Supermercados Sanchez, registrando su compra....");
        System.out.println("Ingrese el descuento correspondiente: ");
        System.out.println("(Indique desde .1(10%) hasta 1(100%), o ingrese un monto fijo)");
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);

        double Descuentoelegido = scan.nextDouble();
        Carrito carrito = new Carrito(numeroCarrito, items, Descuentoelegido); // elegir la cantidad de descuento
        // del 0 al 1 (0.1, 0.2) para elegir DESCUENTO PORCENTAJE (10%, 20%, etc)
        // o ingresar monto fijo para DESCUENTO FIJO (a partir de $2)

        if (carrito.descuento == 0) {
            System.out.println("No se puede aplicar un descuento de $0 a un carrito, descuento no aplicado.");
        } else if (carrito.descuento < 0) {
            System.out.println("Error, el descuento no puede ser un numero negativo.");
        } else {
            double precioTotal = carrito.getDescuento();
            System.out.println("El precio total del carrito " + carrito.getNumeroCarrito() + " es: " + precioTotal);
        }

    }
}
