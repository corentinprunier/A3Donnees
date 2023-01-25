package fr.ensma.a3.ia.convdevisesui.mvc.champnum.automate;

import fr.ensma.a3.ia.convdevisesui.mvc.champnum.ChampNumCtrl;

public class EtatEditable extends AbstractEtatAdapter{
	
	public EtatEditable(ChampNumCtrl c) {
		super(c);
	}
	
	@Override
	public void touche(String txt) throws ChampNumTransitionException {
	}
	
	@Override
	public void vide() throws ChampNumTransitionException {
		ctrl.setEtatCourant(ctrl.getEtatEditableVide());
	}

	@Override
	public void editable() throws ChampNumTransitionException {
		ctrl.setEtatCourant(ctrl.getEtatNonEditable());
	}
	
}
