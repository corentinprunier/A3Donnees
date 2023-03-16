package fr.ensma.a3.ia.td02synchro.aeroport.processus;

import java.util.Random;

import fr.ensma.a3.ia.td02synchro.aeroport.Avion;
import fr.ensma.a3.ia.td02synchro.aeroport.ParkGen;

/**
 * Processus permettant de faire sortir un avion pour décollage.
 *
 * @author Mikky.
 * @version Rev-2022.
 */
public class SortirAvion extends Thread {

    private ParkGen<Avion> sol;

    public SortirAvion(final ParkGen<Avion> psol) {
        super("Th-SortirAvion");
        sol = psol;
    }

    @Override
    public void run() {
        int cmpt = 1;
        Random rand = new Random();
        while (true) {
            Avion av = new Avion("sol-" + cmpt++);
            sol.deposeProd(av);
            System.out.println(av + "déposé ...");
            try {
                sleep(rand.nextInt(50) * 100 + 5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
