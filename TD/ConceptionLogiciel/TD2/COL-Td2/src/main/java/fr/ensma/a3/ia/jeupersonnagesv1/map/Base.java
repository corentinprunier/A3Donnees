package fr.ensma.a3.ia.jeupersonnagesv1.map;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.ensma.a3.ia.jeupersonnagesv1.elements.IElementJeu;
import fr.ensma.a3.ia.jeupersonnagesv1.utils.ValParamException;

/**
 * Modélise une Base de la map.
 *
 * @author Mikky
 *
 */
public class Base {

    private String nomBase;
    private ECouleur coulBase;
    private List<IElementJeu> elem;

    /**
     * Instancie une Base
     *
     * @param nom  String (non null)
     * @param coul {@link ECouleur} (non null)
     * @throws ValParamException
     */
    public Base(final String nom, final ECouleur coul) throws ValParamException {
        try {
            nomBase = Objects.requireNonNull(nom);
            coulBase = Objects.requireNonNull(coul);
            elem = new ArrayList<IElementJeu>();

        } catch (NullPointerException e) {
            throw new ValParamException(getClass().getSimpleName() + " : Param(s) null");
        }
    }

    /**
     * Obtient le nom de la base
     * @return String le nom
     */
    public final String getNomBase() {
        return nomBase;
    }

    /**
     * Obtient la couleur de la base
     * @return {@link ECouleur} la couleur
     */
    public final ECouleur getCoulBase() {
        return coulBase;
    }

    /**
     * Obtient le nombre d'éléments dans la base
     * @return int nb élément(s)
     */
    public final int getNbElem() {
        return elem.size();
    }

    /**
     * Ajoute un élément à la base
     *
     * @param el IElementJeu
     */
    public void addElementJeu(final IElementJeu el) {
        elem.add(el);
    }

    /**
     * Redéfinition de toString
     */
    @Override
    public String toString() {
        StringBuffer buf = new StringBuffer();
        buf.append("Base " + nomBase + ": " + coulBase + "\n");
        buf.append("Éléments jeu :\n");
        for (IElementJeu iter : elem) {
            buf.append("--> " + iter + "\n");
        }
        return buf.toString();
    }

    /** Redéfinition du finallizer */
    @Override
    protected void finalize() throws Throwable {
        logger.info("Bye la classe de type Base...");
    }

    private static Logger logger = LogManager.getLogger(Base.class);

}
