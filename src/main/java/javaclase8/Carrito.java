package javaclase8;

import java.util.*;

public class Carrito {  // 
        private int numeroCarrito;
        private List<ItemCarrito> items;
        public double descuento; // parametro agregado para saber si el descuento es fijo o %

        
        public Carrito(){
            
        }
        
        
        public Carrito(int numeroCarrito, List<ItemCarrito> items, double descuento) {
        this.numeroCarrito = numeroCarrito;
        this.items = items;
        this.descuento = descuento;
    }

        public int getNumeroCarrito(){
            return numeroCarrito;
        }
        
        public void agregarItem(ItemCarrito item) {
        items.add(item);
    }

    public void eliminarItem(ItemCarrito item) {
        items.remove(item);
    }

    public double getDescuento() {
        double total = 0;
        for (ItemCarrito item : items) {
            total = total + item.getTotal();
            }
        if (descuento > 0) {
            if (descuento <= 1) { 
                // El descuento es un porcentaje del total, es decir de 0 al 1 (0.1 = 10%)
                total = total * (1 - descuento);
            } else if(descuento > 1){
                // El descuento es una cantidad fija
                total = total - descuento;
            } 
        }
    
        return total;
    }
}
