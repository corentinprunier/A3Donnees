package fr.ensma.a3.ia.td02synchro.exo1_2_2;

import java.util.concurrent.Semaphore;

public class StartExo2 {

    public static void main(String[] args) {
        IMdd mdd = new MonMdd();
        Semaphore semex = new Semaphore(3,true);

        MonThreadEcrivain th1 = new MonThreadEcrivain(1700, 30, "TH1-Ecrire", mdd, semex);
        MonThreadLecteur th2 = new MonThreadLecteur(300, 20, "TH2-Lire", mdd, semex);
        MonThreadLecteur th3 = new MonThreadLecteur(50, 20, "TH3-Lire", mdd, semex);
        MonThreadLecteur th4 = new MonThreadLecteur(50, 20, "TH4-Lire", mdd, semex);

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
