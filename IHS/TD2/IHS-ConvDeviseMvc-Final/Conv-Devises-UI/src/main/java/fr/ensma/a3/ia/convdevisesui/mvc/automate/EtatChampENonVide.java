package fr.ensma.a3.ia.convdevisesui.mvc.automate;

import fr.ensma.a3.ia.convdevisesui.mvc.ConvertisseurMVCCtrl;

public class EtatChampENonVide extends AbstractEtatGlobalAdapter {

	public EtatChampENonVide(ConvertisseurMVCCtrl c) {
		super(c);
	}
	
	@Override
	public void changementValeur() throws GlobalTransitionNonTirableException {
	}
	
	@Override
	public void changementSelection() throws GlobalTransitionNonTirableException {
	}
	
	@Override
	public void demandeAction() throws GlobalTransitionNonTirableException {
		ctrl.setEtatCourant(ctrl.getEtatChampSNonVide());
	}
	
	@Override
	public void champEntreeVide() throws GlobalTransitionNonTirableException {
		ctrl.setEtatCourant(ctrl.getEtatChampEVide());
	}
}
