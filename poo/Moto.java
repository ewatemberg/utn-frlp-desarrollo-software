package poo;

// Clase concreta que extiende de Vehiculo
public class Moto extends Vehiculo {
    public Moto(String marca) {
        super(marca);
    }

    @Override
    public void conducir() {
        System.out.println(marca + " está en marcha.");
    }
}
