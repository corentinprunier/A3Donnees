package fr.ensma.a3.ia.td02synchro.exo2_1;

public class StartExo2_1 {

    public static void main(String[] args) {
        BalGen<Message> maBal = new BalGen<Message>(5);
        ThreadSend send1 = new ThreadSend("TH1", maBal, 500);
        ThreadSend send2 = new ThreadSend("TH2", maBal, 750);
        ThreadRec rec1 = new ThreadRec(maBal, 7000);
        ThreadRec rec2 = new ThreadRec(maBal, 8000);
        send1.start();
        send2.start();
        rec1.start();
        rec2.start();
    }
}
