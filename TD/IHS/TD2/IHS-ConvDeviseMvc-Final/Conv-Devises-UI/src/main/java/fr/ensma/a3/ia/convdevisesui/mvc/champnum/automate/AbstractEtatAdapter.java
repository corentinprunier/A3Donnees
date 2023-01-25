package fr.ensma.a3.ia.convdevisesui.mvc.champnum.automate;

import fr.ensma.a3.ia.convdevisesui.mvc.champnum.ChampNumCtrl;

public class AbstractEtatAdapter implements IEtat {

	protected ChampNumCtrl ctrl;
	
	public AbstractEtatAdapter(ChampNumCtrl c) {
		ctrl = c;
	}
	
	@Override
	public void touche(String txt) throws ChampNumTransitionException {
		throw new ChampNumTransitionException();		
	}

	@Override
	public void vide() throws ChampNumTransitionException {
		throw new ChampNumTransitionException();
	}

	@Override
	public void editable() throws ChampNumTransitionException {
		throw new ChampNumTransitionException();
	}

	@Override
	public void nonEditable() throws ChampNumTransitionException {
		throw new ChampNumTransitionException();
	}
	
}
