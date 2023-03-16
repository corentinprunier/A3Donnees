package fr.ensma.a3.ia.td02synchro.aeroport.processus;

import java.util.concurrent.Semaphore;

import fr.ensma.a3.ia.td02synchro.aeroport.Avion;
import fr.ensma.a3.ia.td02synchro.aeroport.ParkGen;

/**
 * Processus permettant de faire décoller.
 *
 * @author Mikky.
 * @version Rev-2022.
 */
public class FaireDecoller extends Thread {

    private ParkGen<Avion> balTC;
    private Semaphore semPiste;

    public FaireDecoller(final ParkGen<Avion> bal, final Semaphore sem) {
        super("Th-FaireDecoller");
        balTC = bal;
        semPiste = sem;
    }

    @Override
    public void run() {
        while (true) {
            Avion av = balTC.consoProd();
            try {
                semPiste.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(av + " Decollage autorisé : Go !! .>.>.>.>.>.>.>.>.>.>.>>>>>");
            av = null;
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("=====================Piste Libre==================");
            semPiste.release();
        }
    }
}
