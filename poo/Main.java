package poo;

public class Main {
    public static void main(String[] args) {
        // Polimorfismo
        Coche miCoche = new Coche("Toyota", "Corolla");
        Coche miCocheDeportivo = new CocheDeportivo("Ferrari", "488");

        miCoche.acelerar(50);            // Toyota Corolla ha acelerado a 50 km/h.
        miCocheDeportivo.acelerar(50);   // Ferrari 488 ha acelerado a 50 km/h.
        
        // Mi coche deportivo tiene turbo, pero se trata como un Coche
        ((CocheDeportivo) miCocheDeportivo).activarTurbo();  // El turbo ha sido activado.
        miCocheDeportivo.acelerar(50);   // Ferrari 488 ha acelerado a 150 km/h.
    }
}


