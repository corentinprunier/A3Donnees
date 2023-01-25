package fr.ensma.a3.ia.convdevisesui.mvc.champnum.automate;

import fr.ensma.a3.ia.convdevisesui.mvc.champnum.ChampNumCtrl;

public class EtatEditableVide extends AbstractEtatAdapter{

	public EtatEditableVide(ChampNumCtrl c) {
		super(c);
	}
	
	@Override
	public void touche(String txt) throws ChampNumTransitionException {
		ctrl.setEtatCourant(ctrl.getEtatEditable());
	}
	
	@Override
	public void nonEditable() throws ChampNumTransitionException {
		ctrl.setEtatCourant(ctrl.getEtatNonEditable());
	}
	
}
