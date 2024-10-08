package poo;
// Definición de la clase Coche
public class Coche {
    // Atributos (propiedades)
    private String marca;
    private String modelo;
    private int velocidad;

    // Constructor
    public Coche(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidad = 0;  // Todos los coches inician con velocidad 0
    }

    // Métodos (comportamientos)
    public void acelerar(int incremento) {
        velocidad += incremento;
        System.out.println(marca + " " + modelo + " ha acelerado a " + velocidad + " km/h.");
    }

    public void frenar(int decremento) {
        velocidad -= decremento;
        if (velocidad < 0) velocidad = 0;
        System.out.println(marca + " " + modelo + " ha frenado a " + velocidad + " km/h.");
    }

    // Getter para la velocidad
    public int getVelocidad() {
        return velocidad;
    }
}
