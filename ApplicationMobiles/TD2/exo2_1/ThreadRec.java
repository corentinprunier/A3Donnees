package fr.ensma.a3.ia.td02synchro.exo2_1;

/**
 * Modélisation d'un Thread de reception
 */
public class ThreadRec extends Thread {

    private IBal<Message> bal;
    private int periode;

    public ThreadRec(final IBal<Message> b, final int p) {
        bal = b;
        periode = p;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Message recu : " + bal.receiptMessage());
            
            try {
                sleep(periode);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        }
    }

}
