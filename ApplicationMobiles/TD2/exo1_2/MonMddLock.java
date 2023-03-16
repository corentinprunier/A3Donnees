package fr.ensma.a3.ia.td02synchro.exo1_2;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Implémentation du Mdd en utilisant Lock.
 *
 * @see IMdd
 */
public class MonMddLock implements IMdd {

    private String laData;
    private ReadWriteLock leVerrou;

    public MonMddLock() {
        laData = "";
        leVerrou = new ReentrantReadWriteLock();
    }

    public void ercrireData(final String d) {
        leVerrou.writeLock().lock();
        laData = d;
        leVerrou.writeLock().unlock();
    }

    public String lireData() {
        leVerrou.readLock().lock();
        String d = laData;

        try {

            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            leVerrou.readLock().unlock();
        }
        return d;
    }

}
