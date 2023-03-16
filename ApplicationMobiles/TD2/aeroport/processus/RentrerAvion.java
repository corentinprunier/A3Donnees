package fr.ensma.a3.ia.td02synchro.aeroport.processus;

import java.util.Random;

import fr.ensma.a3.ia.td02synchro.aeroport.Avion;
import fr.ensma.a3.ia.td02synchro.aeroport.ParkGen;

/**
 * Processus permettant de faire rentrer un avion pour atterrissage.
 *
 * @author Mikky.
 * @version Rev-2022.
 */
public class RentrerAvion extends Thread {

    private ParkGen<Avion> air;

    public RentrerAvion(final ParkGen<Avion> pair) {
        super("Th-RentrerAvion");
        air = pair;
    }

    @Override
    public void run() {
        int cmpt = 1;
        Random rand = new Random();
        while (true) {
            Avion av = new Avion("air-" + cmpt++);
            air.deposeProd(av);
            System.out.println(av + "déposé ...");
            try {
                sleep(rand.nextInt(50) * 100 + 1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
