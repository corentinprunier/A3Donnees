package fr.ensma.a3.ia.td02synchro.aeroport.processus;

import java.util.concurrent.CountDownLatch;

/**
 * Processus d'initialisation de la TC
 *
 * @author Mikky.
 * @version Rev-2022.
 */
public class InitSystemTC extends Thread {

    private CountDownLatch sync;

    public InitSystemTC(final CountDownLatch s) {
        super("Th-InitTCSystem");
        sync = s;
    }

    @Override
    public void run() {
        try {
            System.out.println("Préparation des systèmes en cours ...");
            sleep(3500);
            System.out.println("Systemes Ok !");
            sync.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
