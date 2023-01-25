package fr.ensma.a3.ia.jeupersonnagesv1.elements.personnages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.ensma.a3.ia.jeupersonnagesv1.elements.ElementJeu;
import fr.ensma.a3.ia.jeupersonnagesv1.elements.comportement.IDeplacable;
import fr.ensma.a3.ia.jeupersonnagesv1.elements.comportement.etats.AuRepos;
import fr.ensma.a3.ia.jeupersonnagesv1.elements.comportement.etats.EnDeplacement;
import fr.ensma.a3.ia.jeupersonnagesv1.elements.comportement.etats.IAutomate;
import fr.ensma.a3.ia.jeupersonnagesv1.elements.comportement.etats.IEtat;
import fr.ensma.a3.ia.jeupersonnagesv1.elements.comportement.etats.TransitionException;
import fr.ensma.a3.ia.jeupersonnagesv1.map.Base;
import fr.ensma.a3.ia.jeupersonnagesv1.utils.ValParamException;

public abstract class PersoVivant extends ElementJeu implements IDeplacable, IAutomate {

    protected String identPerso;
    private IEtat etatAuRepos;
    private IEtat etatEnDeplacement;
    private IEtat etatCourant;
    
    public PersoVivant(final Float nvie, final Base bse, final String ident) throws ValParamException {
        super(nvie, bse);
        if (ident == null) {
            throw new ValParamException(getClass().getSimpleName() + " : Param(s) null");
        }
        identPerso = ident;
        etatAuRepos = new AuRepos(this);
        etatEnDeplacement = new EnDeplacement(this);
        etatCourant = etatAuRepos;
    }

    public final String getIdentPerso() {
        return identPerso;
    }
    
    @Override
    public final IEtat getEtatAuRepos() {
    	return etatAuRepos;
    }
    
    @Override
    public final IEtat getEtatEnDeplacement() {
		return etatEnDeplacement;
	}

    @Override
    public final void setEtatCourant(final IEtat etat) {
    	etatCourant = etat;
    }
    
    //Ajout de deplacer (depuis IDeplacable) suite à l'ajout du strategy
    @Override
    public void deplacer() {
    	//compoDeplacement.deplacer(this);
    	try {
    		etatCourant.deplacer();
    		compoDeplacement.deplacer(this);
    	} catch (TransitionException ex) {
    		logger.warn("Action demandée non réalisable !!!");
    	}	
    }

  //à Ajouter dans Interface Ideplacable
    public void arretDeplacement() {
    	try {
    		etatCourant.arret();
    	} catch (TransitionException ex) {
    		logger.info("Action demandée non réalisable !!!");
    	}
    	
    }
    
    @Override
    public boolean equals(final Object obj) {
        // Impossible dans une classe abstraite
        // if (this == obj)
        // return true;
        if (!super.equals(obj))
            return false;
        if (!(obj instanceof PersoVivant))
            return false;
        final PersoVivant perso = (PersoVivant) obj;
        // identPerso null impossible par construction
        // if (identPerso == null) {
        // if (perso.identPerso != null)
        // return false;
        // } else if (!identPerso.equals(perso.identPerso))
        // return false;
        if (!identPerso.equals(perso.identPerso)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        // identPerso null impossible par construction
        // result = HASH * result + ((identPerso == null) ? 0 : identPerso.hashCode());
        result = HASH * result + identPerso.hashCode();
        return result;
    }

    private static final int HASH = 13;
    private final Logger logger = LogManager.getLogger(PersoVivant.class);
    
    
    
}
