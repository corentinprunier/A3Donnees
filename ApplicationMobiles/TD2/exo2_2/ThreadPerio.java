package fr.ensma.a3.ia.td02synchro.exo2_2;

import java.util.concurrent.Semaphore;

/**
 * Thread périodique qui déclenche uun autre thread à chaque période
 */
public class ThreadPerio extends Thread {

    private Semaphore semSync;

    public ThreadPerio(final Semaphore s) {
        super("Thread-Périodique");
        semSync = s;
    }

    @Override
    public void run() {
        int inst = 0;
        while (true) {
            System.out.println(getName() + " : Traitement en cours ... " + inst++);
            try {
                sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            semSync.release();
        }
    }
}
