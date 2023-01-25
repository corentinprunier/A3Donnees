package fr.ensma.a3.ia.convdevisesui.mvc.compoaction.etats;

public interface IEtat {
	void click () throws TransitionException;
	void chgtSelection () throws TransitionException;
	void eCombo()throws TransitionException;
	void dCombo() throws TransitionException;
	void eButton() throws TransitionException;
	void dButton() throws TransitionException;
}
