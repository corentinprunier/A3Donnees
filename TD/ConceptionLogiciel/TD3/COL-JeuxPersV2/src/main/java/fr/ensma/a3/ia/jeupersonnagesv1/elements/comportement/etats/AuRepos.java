package fr.ensma.a3.ia.jeupersonnagesv1.elements.comportement.etats;

public class AuRepos extends AbstractEtat {

	public AuRepos (final IAutomate aut) {
		super(aut);
	}
	
	@Override
	public void deplacer() throws TransitionException {
		autom.setEtatCourant(autom.getEtatEnDeplacement());
	}
}
