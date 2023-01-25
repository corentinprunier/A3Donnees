package fr.ensma.a3.ia.jeupersonnagesv1.map;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
}
