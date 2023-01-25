package fr.ensma.a3.ia.convdevisesui.mvc.champnum;

import fr.ensma.a3.ia.convdevisesui.mvc.champnum.automate.ChampNumTransitionException;
import fr.ensma.a3.ia.convdevisesui.mvc.champnum.automate.EtatEditable;
import fr.ensma.a3.ia.convdevisesui.mvc.champnum.automate.EtatEditableVide;
import fr.ensma.a3.ia.convdevisesui.mvc.champnum.automate.EtatNonEditable;
import fr.ensma.a3.ia.convdevisesui.mvc.champnum.automate.IEtat;

public class ChampNumCtrl {

	private ChampNumVue vue;
	private ChampNumModele mod;

	private IEtat etatCourant;
	private IEtat etatEditableVide = new EtatEditableVide(this);
	private IEtat etatEditable = new EtatEditable(this); 
	private IEtat etatNonEditable = new EtatNonEditable(this);


	public ChampNumCtrl(final ChampNumModele m, final Boolean edit) {
		mod = m;
		vue = new ChampNumVue(this,mod);
		if (edit) {
			etatCourant = etatEditableVide;
		} else {
			etatCourant = etatNonEditable;
		}
	}
	
	public void actionTouche(String val) {
		try {
			if (val.compareTo("")==0) {
				etatCourant.vide();
				mod.setValChamp(val);
				mod.chpVide();
			} else {
				etatCourant.touche(val);
				mod.setValChamp(val);
			}			
		} catch (ChampNumTransitionException e) {
			//Log
		}
	}
	
	public ChampNumVue getVue() {
		return vue;
	}
	
	public void setEtatCourant(final IEtat e) {
		etatCourant = e;
	}
	
	public IEtat getEtatEditableVide() {
		return etatEditableVide;
	}
	
	public IEtat getEtatEditable() {
		return etatEditable;
	}
	
	public IEtat getEtatNonEditable() {
		return etatNonEditable;
	}
	
}
