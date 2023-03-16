package fr.ensma.a3.ia.jeupersonnagesv1.elements.groupements;

import fr.ensma.a3.ia.jeupersonnagesv1.elements.comportement.IDeplacable;

public interface ITroupe {

	public void rejoindreTroupe(final IDeplacable elem);
	public void quitterTroupe (final IDeplacable elem);
	public void deplacer();

}
