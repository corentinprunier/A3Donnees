package fr.ensma.a3.ia.td02synchro.exo1_2;

public class StartExo1_2bis {

    public static void main(String[] args) {
        // Version Lock
        IMdd mdd2 = new MonMddLock();
        // version Synchronized
        IMdd mdd = new MonMdd();

        MonThreadEcrivain th1 = new MonThreadEcrivain(1700, 30, "TH1-Ecrire", mdd2);
        MonThreadLecteur th2 = new MonThreadLecteur(300, 20, "TH2-Lire", mdd2);
        MonThreadLecteur th3 = new MonThreadLecteur(50, 20, "TH3-Lire", mdd2);
        MonThreadLecteur th4 = new MonThreadLecteur(50, 20, "TH4-Lire", mdd2);

        th1.start();
        th2.start();
        th3.start();
        th4.start();

        try {
            th2.join(10000);
            th1.join(20000);
            System.out.println("===========Prog FINI============");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
