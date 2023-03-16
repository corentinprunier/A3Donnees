package fr.ensma.a3.ia.td02synchro.aeroport.processus;

import java.util.concurrent.Semaphore;

import fr.ensma.a3.ia.td02synchro.aeroport.Avion;
import fr.ensma.a3.ia.td02synchro.aeroport.ParkGen;

/**
 * Processus permettant de faire atterrir.
 *
 * @author Mikky.
 * @version Rev-2022.
 */
public class FaireAtterrir extends Thread {

    private ParkGen<Avion> balTC;
    private Semaphore semPiste;

    public FaireAtterrir(final ParkGen<Avion> bal, final Semaphore s) {
        super("Th-FaireAtterrir");
        balTC = bal;
        semPiste = s;
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
            System.out.println(av + " Atterrissage autorisé : Go !! <<<<<.<.<.<.<.<.<.<.<.<.<.<.<...");
            av = null;
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("=====================Piste Libre==================");
            semPiste.release();
        }
    }
}
