package fr.ensma.a3.ia.convdevisesui.mvc.automate;

import fr.ensma.a3.ia.convdevisesui.mvc.ConvertisseurMVCCtrl;

public class EtatChampEVide extends AbstractEtatGlobalAdapter{

	public EtatChampEVide(ConvertisseurMVCCtrl c) {
		super(c);
	}
	
	
	@Override
	public void changementValeur() throws GlobalTransitionNonTirableException {
		ctrl.setEtatCourant(ctrl.getEtatChampENonVide());
	}
}
