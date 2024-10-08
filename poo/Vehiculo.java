package poo;

// Clase abstracta Vehiculo
public abstract class Vehiculo {
    protected String marca;

    public Vehiculo(String marca) {
        this.marca = marca;
    }

    public abstract void conducir();  // Método abstracto
}
