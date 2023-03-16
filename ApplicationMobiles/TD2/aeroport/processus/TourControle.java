package fr.ensma.a3.ia.td02synchro.aeroport.processus;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

import fr.ensma.a3.ia.td02synchro.aeroport.Avion;
import fr.ensma.a3.ia.td02synchro.aeroport.ParkGen;

/**
 * Processus modélisant la tour de contrôle.
 *
 * @author Mikky.
 * @version Rev-2022.
 */
public class TourControle extends Thread {

    private ParkGen<Avion> air, sol;
    private ParkGen<Avion> balTCDeco, balTCAtt;
    private CountDownLatch sync;
    private Semaphore semPiste;

    private PrepaPiste thPrepaPiste;
    private InitSystemTC thInitSystem;
    private SortirAvion thSortirAvion;
    private RentrerAvion thRentrerAvion;

    private DemandeDecoller thDemandeDeco;
    private DemandeAtterrir thDemandeAtter;
    private FaireDecoller thFaireDecoller;
    private FaireAtterrir thFaireAtter;

    public TourControle() {
        super("Th-TourControle");
        air = new ParkGen<Avion>(8, "zone Air");
        sol = new ParkGen<Avion>(3, "zone sol");
        balTCDeco = new ParkGen<Avion>(1, "BalDeco");
        balTCAtt = new ParkGen<Avion>(1, "balAtt");
        sync = new CountDownLatch(2);
        semPiste = new Semaphore(1, false);

        thPrepaPiste = new PrepaPiste(sync);
        thInitSystem = new InitSystemTC(sync);
        thSortirAvion = new SortirAvion(sol);
        thRentrerAvion = new RentrerAvion(air);
        thDemandeDeco = new DemandeDecoller(sol, balTCDeco);
        thDemandeAtter = new DemandeAtterrir(air, balTCAtt);
        thFaireDecoller = new FaireDecoller(balTCDeco, semPiste);
        thFaireAtter = new FaireAtterrir(balTCAtt, semPiste);
    }

    @Override
    public void run() {
        thPrepaPiste.start();
        thInitSystem.start();
        try {
            sync.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thSortirAvion.start();
        thRentrerAvion.start();
        thDemandeDeco.start();
        thDemandeAtter.start();
        thFaireDecoller.start();
        thFaireAtter.start();
    }
}
