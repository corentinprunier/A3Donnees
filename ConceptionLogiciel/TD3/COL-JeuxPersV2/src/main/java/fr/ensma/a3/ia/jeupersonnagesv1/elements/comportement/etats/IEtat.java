package fr.ensma.a3.ia.jeupersonnagesv1.elements.comportement.etats;

public interface IEtat {
	
	public void deplacer() throws TransitionException;
	public void arret() throws TransitionException;

}
