package fr.ensma.a3.ia.convdevisesui.mvc.compoaction.etats;

public class EtatButtonEnable extends AbstractEtat {

	public EtatButtonEnable(final IAutomate aut) {
		super(aut);
	}
	
	@Override
	public void dButton() throws TransitionException {
		autom.setEtatCourant(autom.getEtatAllDisable());

	}
	
	@Override
	public void eCombo() throws TransitionException {
		autom.setEtatCourant(autom.getEtatAllEnable());
	}
	
	@Override
	public void click() throws TransitionException {
	}
}
