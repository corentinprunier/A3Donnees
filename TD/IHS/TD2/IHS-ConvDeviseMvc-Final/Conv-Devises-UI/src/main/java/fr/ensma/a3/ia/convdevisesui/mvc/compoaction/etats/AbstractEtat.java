package fr.ensma.a3.ia.convdevisesui.mvc.compoaction.etats;

public abstract class AbstractEtat implements IEtat {

	protected IAutomate autom;

	public AbstractEtat(final IAutomate aut) {
		autom = aut;
	}
	
	@Override
	public void click() throws TransitionException {
		throw new TransitionException();
	}

	@Override
	public void chgtSelection() throws TransitionException {
		throw new TransitionException();
	}

	@Override
	public void eCombo() throws TransitionException {
		throw new TransitionException();
	}
	
	@Override
	public void dCombo() throws TransitionException {
		throw new TransitionException();
	}
	
	@Override
	public void eButton() throws TransitionException {
		throw new TransitionException();
	}
	
	@Override
	public void dButton() throws TransitionException {
		throw new TransitionException();
	}
	
	
}
