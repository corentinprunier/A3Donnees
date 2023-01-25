package fr.ensma.a3.ia.convdevisesui.mvc.compoaction.etats;

public class EtatAllDisable extends AbstractEtat {

	public EtatAllDisable(final IAutomate aut) {
		super(aut);
	}

	@Override
	public void eCombo() throws TransitionException {
		autom.setEtatCourant(autom.getEtatComboEnable());
	}
	
	@Override
	public void eButton() throws TransitionException {
		autom.setEtatCourant(autom.getEtatButtonEnable());
	}
	
}
