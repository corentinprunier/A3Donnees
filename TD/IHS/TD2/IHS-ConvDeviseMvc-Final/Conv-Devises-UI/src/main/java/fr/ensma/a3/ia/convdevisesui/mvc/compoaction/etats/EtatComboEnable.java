package fr.ensma.a3.ia.convdevisesui.mvc.compoaction.etats;

public class EtatComboEnable extends AbstractEtat {

	public EtatComboEnable (final IAutomate aut) {
		super(aut);
	}
	
	@Override
	public void dCombo() throws TransitionException {
		autom.setEtatCourant(autom.getEtatAllDisable());
	}
	
	@Override
	public void eButton() throws TransitionException {
		autom.setEtatCourant(autom.getEtatAllEnable());
	}
	
	@Override
	public void chgtSelection() throws TransitionException {
	}
}
