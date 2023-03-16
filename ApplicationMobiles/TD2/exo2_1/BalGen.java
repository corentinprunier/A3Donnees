package fr.ensma.a3.ia.td02synchro.exo2_1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Implémentation de la BaL générique à NbplaceMax.
 *
 * @see IBal, IBalMessage
 */
public class BalGen<Mess extends IBalMessage> implements IBal<Mess> {

    private int nbPlaceMax;
    private Lock leVerrou;
    private Condition attPlace, attMess;
    private List<Mess> filAtt;

    public BalGen(final int taille) {
        leVerrou = new ReentrantLock();
        attMess = leVerrou.newCondition();
        attPlace = leVerrou.newCondition();
        filAtt = new ArrayList<Mess>();
        nbPlaceMax = taille;
    }

    public void sendMessage(final Mess m) {
        leVerrou.lock();
        while (filAtt.size() == nbPlaceMax) {
            try {
                attPlace.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        filAtt.add(m);
        System.out.println("Message ajouté ...");
        attMess.signalAll();
        leVerrou.unlock();
    }

    public Mess receiptMessage() {
        leVerrou.lock();
        while (filAtt.size() == 0) {
            try {
                attMess.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Mess m = filAtt.remove(filAtt.size() - 1);
        attPlace.signalAll();
        leVerrou.unlock();
        return m;
    }

}
