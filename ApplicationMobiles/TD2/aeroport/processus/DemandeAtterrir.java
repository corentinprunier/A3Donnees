package fr.ensma.a3.ia.td02synchro.aeroport.processus;

import fr.ensma.a3.ia.td02synchro.aeroport.Avion;
import fr.ensma.a3.ia.td02synchro.aeroport.ParkGen;

/**
 * Processus permettant de demander un atterrissage.
 * @author Mikky.
 * @version Rev-2022.
 */
public class DemandeAtterrir extends Thread {

    private ParkGen<Avion> air;
    private ParkGen<Avion> balTC;

    public DemandeAtterrir(final ParkGen<Avion> pa, final ParkGen<Avion> bal) {
        super("Th-DemandeAtterrir");
        air = pa;
        balTC = bal;
    }

    @Override
    public void run() {
        while (true) {
            Avion av = air.consoProd();
            System.out.println(av + " demande atterrissage ...???????????");
            balTC.deposeProd(av);
            try {
                sleep(850);
            } catch (InterruptedException e) {
                // TODO Bloc catch généré automatiquement
                e.printStackTrace();
            }
        }
    }
}
