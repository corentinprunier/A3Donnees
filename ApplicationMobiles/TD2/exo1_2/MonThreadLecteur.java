package fr.ensma.a3.ia.td02synchro.exo1_2;

/**
 * Modélisation d'un Thread Lecteur périodique. Récupère périodiquement la
 * valeur contenue dans le Mdd.
 *
 * @see IMdd, MonMdd
 */
public class MonThreadLecteur extends Thread {

    private long maPeriode;
    private int maDuree;
    private IMdd leMdd;
    private int numIte = 0;

    public MonThreadLecteur(long perio, int duree, String nom, IMdd md) {
        super(nom);
        maPeriode = perio;
        maDuree = duree;
        leMdd = md;
    }

    @Override
    public void run() {
        long reveil = System.currentTimeMillis();
        while (System.currentTimeMillis() <= reveil + (maDuree * 1000)) {
            System.out.println(getName() + " s'execute a :" + System.currentTimeMillis() + " -> iteration : " + ++numIte
                    + "; vient de lire : " + leMdd.lireData());
            try {
                sleep(maPeriode);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
