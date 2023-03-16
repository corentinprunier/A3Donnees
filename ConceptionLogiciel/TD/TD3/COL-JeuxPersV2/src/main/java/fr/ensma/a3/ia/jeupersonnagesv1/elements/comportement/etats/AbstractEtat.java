package fr.ensma.a3.ia.jeupersonnagesv1.elements.comportement.etats;

public abstract class AbstractEtat implements IEtat {

	protected IAutomate autom;
	
	public AbstractEtat(final IAutomate aut) {
		autom = aut;
	}
	
	@Override
	public void deplacer() throws TransitionException {
		throw new TransitionException();
	}

	@Override
	public void arret() throws TransitionException {
		throw new TransitionException();
	}

}
