package fr.ensma.a3.ia.convdevisesui.mvc.champnum.automate;

public interface IEtat {
	void touche(final String txt) throws ChampNumTransitionException;
	void vide() throws ChampNumTransitionException;
	void editable() throws ChampNumTransitionException;
	void nonEditable() throws ChampNumTransitionException;
}

