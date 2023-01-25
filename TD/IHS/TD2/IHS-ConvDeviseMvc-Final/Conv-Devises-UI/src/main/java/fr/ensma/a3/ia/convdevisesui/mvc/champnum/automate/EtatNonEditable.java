package fr.ensma.a3.ia.convdevisesui.mvc.champnum.automate;

import fr.ensma.a3.ia.convdevisesui.mvc.champnum.ChampNumCtrl;

public class EtatNonEditable extends AbstractEtatAdapter{

	public EtatNonEditable(ChampNumCtrl c) {
		super(c);
	}
	
	@Override
	public void editable() throws ChampNumTransitionException {
		ctrl.setEtatCourant(ctrl.getEtatEditableVide());
	}
}
