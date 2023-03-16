package fr.ensma.a3.ia.td02synchro.aeroport;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Modélisation d'une zone de stockage générique (Famille IProd)
 *
 * @see IProd
 * @author Mikky.
 * @version Rev-2022.
 */
public class ParkGen<T extends IProd> {

    private List<T> stock;
    private int tMax;
    private ReentrantLock leVerrou;
    private Condition attPlace, attProd;
    private String nom;

    public ParkGen(final int t, final String n) {
        tMax = t;
        nom = n;
        stock = new ArrayList<T>();
        leVerrou = new ReentrantLock();
        attPlace = leVerrou.newCondition();
        attProd = leVerrou.newCondition();
    }

    public void deposeProd(final T p) {
        leVerrou.lock();
        try {
            while (stock.size() == tMax) {
                attPlace.await();
            }
            stock.add(p);
            System.out.println("Ajout de " + p.toString() + "dans " + nom);
            attProd.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            leVerrou.unlock();
        }
    }

    public T consoProd() {
        T p = null;
        leVerrou.lock();
        try {
            while (stock.size() == 0) {
                attProd.await();
            }
            p = stock.remove(0);
            System.out.println("Suppression de " + p.toString() + "dans " + nom);
            attPlace.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            leVerrou.unlock();
        }
        return p;
    }
}
