package fr.ensma.a3.ia.td02synchro.aeroport.processus;

import fr.ensma.a3.ia.td02synchro.aeroport.Avion;
import fr.ensma.a3.ia.td02synchro.aeroport.ParkGen;

/**
 * Processus permettant de demander un décollage.
 * @author Mikky.
 * @version Rev-2022.
 */
public class DemandeDecoller extends Thread {

    private ParkGen<Avion> sol;
    private ParkGen<Avion> balTC;

    public DemandeDecoller(final ParkGen<Avion> ps, final ParkGen<Avion> bal) {
        super("Th-DemandeDecoller");
        sol = ps;
        balTC = bal;
    }

    @Override
    public void run() {
        while (true) {
            Avion av = sol.consoProd();
            System.out.println(av + " demande décollage ...???????????");
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
