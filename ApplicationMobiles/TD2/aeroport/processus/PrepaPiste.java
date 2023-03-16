package fr.ensma.a3.ia.td02synchro.aeroport.processus;

import java.util.concurrent.CountDownLatch;

/**
 * Processus de préparation de la piste.
 *
 * @author Mikky.
 * @version Rev-2022.
 */
public class PrepaPiste extends Thread {

    private CountDownLatch sync;

    public PrepaPiste(final CountDownLatch cdl) {
        super("Th-PrepaPiste");
        sync = cdl;
    }

    @Override
    public void run() {
        try {
            System.out.println("Préparation piste en cours ...");
            sleep(2500);
            System.out.println("Piste Ok !");
            sync.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
