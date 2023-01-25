package fr.ensma.a3.ia.jeupersonnagesv1.elements.groupements;

import java.util.ArrayList;
import java.util.List;

import fr.ensma.a3.ia.jeupersonnagesv1.elements.comportement.IDeplacable;
import fr.ensma.a3.ia.jeupersonnagesv1.utils.ValParamException;

public class Troupe implements ITroupe, IDeplacable{

	private List<IDeplacable> laTroupe;
	
	public Troupe (final IDeplacable elem) throws ValParamException {
		if (elem == null) {
			throw new ValParamException(getClass().getSimpleName() + " : Param null");
		}
		laTroupe = new ArrayList<IDeplacable>();
		laTroupe.add(elem);
	}
	
	public final int getNbElem() {
		return laTroupe.size();
	}
	
	@Override
	public void rejoindreTroupe(final IDeplacable elem) {
		laTroupe.add(elem);
	}

	@Override
	public void quitterTroupe(final IDeplacable elem) {
		laTroupe.remove(elem);
	}

	@Override
	public void deplacer() {
		for (IDeplacable iter : laTroupe) {
			iter.deplacer();
		}		
	}

}
