package fr.ensma.a3.ia.convdevisesui.mvc.automate;

import fr.ensma.a3.ia.convdevisesui.mvc.ConvertisseurMVCCtrl;

public abstract class AbstractEtatGlobalAdapter implements IEtatGlobal {

	protected ConvertisseurMVCCtrl ctrl;

	public AbstractEtatGlobalAdapter(ConvertisseurMVCCtrl c) {
		ctrl = c;
	}

	@Override
	public void champEntreeVide() throws GlobalTransitionNonTirableException {
		throw new GlobalTransitionNonTirableException();
	}

	@Override
	public void changementValeur() throws GlobalTransitionNonTirableException {
		throw new GlobalTransitionNonTirableException();
	}

	@Override
	public void changementSelection() throws GlobalTransitionNonTirableException {
		throw new GlobalTransitionNonTirableException();
	}

	@Override
	public void toucheA() throws GlobalTransitionNonTirableException {
		throw new GlobalTransitionNonTirableException();
	}
	
	@Override
	public void demandeAction() throws GlobalTransitionNonTirableException{
		throw new GlobalTransitionNonTirableException();
	}
	
}
