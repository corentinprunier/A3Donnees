package fr.ensma.a3.ia.td02synchro.exo2_1;

/**
 * Interface de la BaL Générique (ds la famille des IBalMessages)
 */
public interface IBal<Mess extends IBalMessage> {

    /**
     * Envoie d'un message.
     * La méthode peut être bloquante (pas de place)
     * @param Mess m, le message à envoyer
     */
    void sendMessage(final Mess m);

    /**
     * Reception d'un message.
     * La méthode peut-être bloquante (pas de message)
     * @return Mess, le message reçu
     */
    Mess receiptMessage();
}
