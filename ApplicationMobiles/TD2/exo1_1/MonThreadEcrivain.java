package fr.ensma.a3.ia.td02synchro.exo1_1;

/**
 * Modélisation d'un Thread Ecrivain périodique.
 * Dépose une valeur dans le Mdd.
 * @see IMdd, MonMdd
 */
public class MonThreadEcrivain extends Thread {

    private long maPeriode;
    private int maDuree;
    private IMdd leMdd;
    private int numIte = 0;

    public MonThreadEcrivain(final long perio, final int duree, final String nom, final IMdd md) {
        super(nom);
        maPeriode = perio;
        maDuree = duree;
        leMdd = md;
    }

    @Override
    public void run() {
        long reveil = System.currentTimeMillis();
        while (System.currentTimeMillis() <= reveil + (maDuree * 1000)) {
            System.out.println(getName() + " s'execute a :" + System.currentTimeMillis());
            leMdd.ercrireData("nomThread - " + ++numIte);
            try {
                sleep(maPeriode);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
