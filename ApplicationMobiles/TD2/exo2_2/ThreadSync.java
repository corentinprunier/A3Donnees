package fr.ensma.a3.ia.td02synchro.exo2_2;

import java.util.concurrent.Semaphore;

/**
 * Thread déclenché par un thread périodique (toutes les périodes).
 */
public class ThreadSync extends Thread {

    private Semaphore semSync;

    public ThreadSync(final Semaphore s) {
        super("Thread-Synchrone");
        semSync = s;
    }

    @Override
    public void run() {
        int inst = 0;
        while (true) {
            try {
                semSync.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName() + " : Déclenchement ..." + inst++);
        }
    }

}
