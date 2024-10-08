package poo;

// Clase CocheDeportivo que hereda de Coche
public class CocheDeportivo extends Coche {
    private boolean turbo;

    public CocheDeportivo(String marca, String modelo) {
        super(marca, modelo);
        this.turbo = false;
    }

    public void activarTurbo() {
        turbo = true;
        System.out.println("El turbo ha sido activado.");
    }

    // Sobrescribiendo el método acelerar
    @Override
    public void acelerar(int incremento) {
        if (turbo) {
            incremento *= 2;  // El coche acelera el doble si el turbo está activado
        }
        super.acelerar(incremento);
    }
}
