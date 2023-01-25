package fr.ensma.a3.ia.convdevisesui.mvc.automate;

import fr.ensma.a3.ia.convdevisesui.mvc.ConvertisseurMVCCtrl;

public class EtatChampSNonVide extends AbstractEtatGlobalAdapter{

	public EtatChampSNonVide(ConvertisseurMVCCtrl c) {
		super(c);
	}
	
	@Override
	public void toucheA() throws GlobalTransitionNonTirableException {
		ctrl.setEtatCourant(ctrl.getEtatChampEVide());
	}
}
