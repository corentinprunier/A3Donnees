package carnetcontacts;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import carnetcontacts.contacts.AbstractContact;
import carnetcontacts.contacts.Contact;
import carnetcontacts.contacts.ContactEntr;
import carnetcontacts.contacts.ECategorie;
import carnetcontacts.coordonnees.Coordonnees;
import carnetcontacts.coordonnees.adresses.AdresseEu;
import carnetcontacts.coordonnees.adresses.ETypAdr;
import carnetcontacts.utils.ValParamException;

/**
 * Application du Carnet de contacts
 *
 * @author Mikky
 * @version 1.0.0
 */
public class App {

    public static void main(String[] args) {
        System.out.println(ETypAdr.US);
        // Tests Adresses
        AdresseEu adr_eu;
        try {
            adr_eu = new AdresseEu(44, "rue des pointeurs", "JavaLand", ETypAdr.Eur, "86000");
            System.out.println(adr_eu);

            AdresseEu adr_eu2 = new AdresseEu(44, "rue des pointeurs", "JavaLand", ETypAdr.Eur, "86000");
            System.out.println(adr_eu == adr_eu2);
            System.out.println(adr_eu.equals(adr_eu2));
            // Test la levée de l'exception ValParamExcception
            // AdresseEu adr_eu3 = new AdresseEu(null, "rue des pointeurs", "JavaLand",
            // ETypAdr.Eur, "86000");
            // System.out.println(adr_eu3);
            // Test coordonnées
            Coordonnees coord_1;
            try {
                coord_1 = new Coordonnees("06.12", "05.49", adr_eu);
                System.out.println(coord_1);
                Coordonnees coord_2 = new Coordonnees("06.12", "05.49", adr_eu);
                System.out.println(coord_1 == coord_2);
                System.out.println(coord_1.equals(coord_2));
                // Test la levée d'exception
                // Coordonnees coord_3 = new Coordonnees(null, null);
                // System.out.println(coord_3);
                // Test contacts
                ContactEntr cont_entr;
                Contact cont;
                try {
                    cont = new Contact("Leponge", "Bob", coord_1, LocalDate.of(1912, Month.MARCH, 22));
                    System.out.println(cont);
                    System.out.println(cont.getDateNaissContact() + "-->" + cont.getAgeContact() + "an(s)");
                    Contact cont2 = new Contact("Leponge", "Bob", coord_1, LocalDate.of(1912, Month.MARCH, 22));
                    System.out.println(cont == cont2);
                    System.out.println(cont.equals(cont2));
                    cont_entr = new ContactEntr("Le Roi Merlin", coord_2, ECategorie.Commerce);
                    cont_entr.setNumsiret(12554687);
                    System.out.println(cont_entr);
                    ContactEntr cont_entr2 = new ContactEntr("Le Roi Merlin", coord_2, ECategorie.Commerce);
                    cont_entr2.setNumsiret(12554687);
                    System.out.println(cont.equals(cont_entr));
                    System.out.println(cont_entr == cont_entr2);
                    System.out.println(cont_entr.equals(cont_entr2));
                    // Test carnet
                    CarnetContacts carnet;
                    try {
                        carnet = new CarnetContacts("Mon carnet", cont);
                        System.out.println(carnet);
                        carnet.Add(cont_entr);
                        System.out.println(carnet);
                        if (carnet.remove(cont)) {
                            System.out.println(carnet);
                        } else {
                            System.out.println("Contact absent !");
                        }
                        List<AbstractContact> lres = carnet.searchByName("Le Roi Merlin");
                        for (AbstractContact _iter : lres) {
                            System.out.println(_iter);
                        }
                    } catch (ValParamException ex) {
                        ex.printStackTrace();
                    }
                } catch (ValParamException ex) {
                    ex.printStackTrace();
                }

            } catch (ValParamException ex) {
                System.out.println("Pb instanciation coord");
                ex.printStackTrace();
            }
        } catch (ValParamException ex) {
            System.out.println("Pb instanciation adr_eu");
            ex.printStackTrace();
        }
    }

}
