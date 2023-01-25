package fr.ensma.a3.ia.convdevisesui.mvc.compoaction.etats;

public interface IAutomate {

	void setEtatCourant(final IEtat etat);
	IEtat getEtatAllEnable();
	IEtat getEtatAllDisable();
	IEtat getEtatButtonEnable();
	IEtat getEtatComboEnable();
	
}
