package fr.ensma.a3.ia.jeupersonnagesv1.elements.comportement.etats;

public interface IAutomate {

	public IEtat getEtatAuRepos();
	public IEtat getEtatEnDeplacement();
	public void  setEtatCourant (final IEtat et);
	
}
