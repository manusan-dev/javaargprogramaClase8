
package javaclase8;


public class Descuento {
    private int numeroCarrito;
    private double porcentaje;

    public Descuento(int numeroCarrito, double porcentaje) {
        this.numeroCarrito = numeroCarrito;
        this.porcentaje = porcentaje;
    }

    public int getNumero() {
        return numeroCarrito;
    }

    public double getPorcentaje() {
        return porcentaje;
    }
}