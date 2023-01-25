package fr.ensma.a3.ia.jeupersonnagesv1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.ensma.a3.ia.jeupersonnagesv1.elements.personnages.animaux.Dragon;
import fr.ensma.a3.ia.jeupersonnagesv1.elements.personnages.humains.Guerrier;
import fr.ensma.a3.ia.jeupersonnagesv1.elements.personnages.humains.Ouvrier;
import fr.ensma.a3.ia.jeupersonnagesv1.map.Base;
import fr.ensma.a3.ia.jeupersonnagesv1.map.ECouleur;
import fr.ensma.a3.ia.jeupersonnagesv1.utils.ValParamException;

/**
 * Jeu des Personnages !
 *
 * @author Mikky
 * @version 1.0
 *
 */
public class App {

    private static Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        try {
            Base winterfell = new Base("Winterfell", ECouleur.bleu);
            Ouvrier hodor = new Ouvrier(255.0f, winterfell, 2500, "Hodor");
            Guerrier jSnow = new Guerrier(150.0f, winterfell, 450, "John Snow");
            Base castralRoc = new Base("Castral Roc", ECouleur.rouge);
            Guerrier joffrey = new Guerrier(75.0f, castralRoc, 200, "Joffrey");
            Base peyredragon = new Base("Peyredragon", ECouleur.jaune);
            Dragon viserion = new Dragon(2000.0f, peyredragon, "Viserion", 3000);
            Dragon drogon = new Dragon(3500.0f, peyredragon, "Drogon", 3500);
            System.out.println(hodor);
            System.out.println(jSnow);
            System.out.println(joffrey);
            System.out.println(viserion);
            System.out.println(drogon);

            System.out.println(winterfell);
            System.out.println(castralRoc);
            System.out.println(peyredragon);

            hodor.deplacer();
            jSnow.deplacer();
            joffrey.deplacer();
            viserion.deplacer();
            drogon.deplacer();

            jSnow.aLAttaque(joffrey);
            joffrey.aLAttaque(hodor);
            //joffrey.aLAttaque(viserion);
            viserion.aLAttaque(joffrey);
            drogon.aLAttaque(viserion);

            System.out.println(hodor.equals(hodor));
            System.out.println(hodor.equals(null));
            System.out.println(hodor.equals(jSnow));

        } catch (ValParamException e) {
            logger.error("Erreur(s) paramètre(s) !");
            e.printStackTrace();
        }
    }
}
