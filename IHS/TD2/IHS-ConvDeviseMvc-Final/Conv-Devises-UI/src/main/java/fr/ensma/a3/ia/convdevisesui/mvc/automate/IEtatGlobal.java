package fr.ensma.a3.ia.convdevisesui.mvc.automate;

public interface IEtatGlobal {

	void champEntreeVide() throws GlobalTransitionNonTirableException;
	void changementValeur() throws GlobalTransitionNonTirableException;
	void changementSelection() throws GlobalTransitionNonTirableException;
	void toucheA() throws GlobalTransitionNonTirableException;
	void demandeAction() throws GlobalTransitionNonTirableException;
}
