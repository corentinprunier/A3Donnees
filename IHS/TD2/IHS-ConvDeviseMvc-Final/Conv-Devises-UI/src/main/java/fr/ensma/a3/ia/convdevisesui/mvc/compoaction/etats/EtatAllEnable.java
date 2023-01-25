package fr.ensma.a3.ia.convdevisesui.mvc.compoaction.etats;

public class EtatAllEnable extends AbstractEtat {

	public EtatAllEnable(final IAutomate aut) {
		super(aut);
	}
	
	@Override
	public void click() throws TransitionException {
		//Log
		// Pas de chgmt d'état
	}
	
	@Override
	public void chgtSelection() throws TransitionException {
		//Log
		//Pas de chmt d'état
	}
	
	@Override
	public void dButton() throws TransitionException {
		autom.setEtatCourant(autom.getEtatComboEnable());
	}
	
	@Override
	public void dCombo() throws TransitionException {
		autom.setEtatCourant(autom.getEtatButtonEnable());
	}
	
}
