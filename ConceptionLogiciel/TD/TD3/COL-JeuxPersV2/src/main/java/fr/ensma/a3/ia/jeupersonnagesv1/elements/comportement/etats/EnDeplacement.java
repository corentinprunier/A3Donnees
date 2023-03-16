package fr.ensma.a3.ia.jeupersonnagesv1.elements.comportement.etats;

public class EnDeplacement extends AbstractEtat {
	
	public EnDeplacement (final IAutomate aut) {
		super(aut);
	}
	
	@Override
	public void arret() throws TransitionException {
		autom.setEtatCourant(autom.getEtatAuRepos());
	}
}
