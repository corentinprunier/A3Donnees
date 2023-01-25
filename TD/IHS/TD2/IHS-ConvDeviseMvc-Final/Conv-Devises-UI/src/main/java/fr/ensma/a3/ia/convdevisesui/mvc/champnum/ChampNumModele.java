package fr.ensma.a3.ia.convdevisesui.mvc.champnum;

import java.util.ArrayList;
import java.util.List;

public class ChampNumModele {

	private ChampNumCtrl ctrl;	
	private ChampNumVue vue;
	
	private String leLabel;
	private Boolean editChamp;
	private Boolean enableChamp;
	private String valChamp;
	
	List<ICompoChampNumObserver> mesObserveurs;
	
	public ChampNumModele(final Boolean edit, final Boolean enable, final String lab) {
		leLabel = lab;
		valChamp ="";
		editChamp = edit;
		enableChamp = enable;
		
		ctrl = new ChampNumCtrl(this, edit);
		vue = ctrl.getVue();
		mesObserveurs = new ArrayList<ICompoChampNumObserver>();
	}
	
	public void ecouteCompoChpNum(ICompoChampNumObserver obs) {
		mesObserveurs.add(obs);
	}
	
	public void stopEcouteChpNum(ICompoChampNumObserver obs) {
		mesObserveurs.remove(obs);
	}
	
	public ChampNumVue getVue() {
		return vue;
	}
/*	
	public void setVue(final VueAgentTexte v) {
		vue = v;
	}
*/	
	public String getLeLabel() {
		return leLabel;
	}
	
	public String getValChamp() {
		return valChamp;
	}
	
	public Boolean setValChamp(final String v) {
		if (v.matches("\\d+(\\.\\d*)?|\\.\\d+")) {
			valChamp = v;
			vue.miseAJour();	
			chgmtVal(valChamp);
			return true;
		}
		if(v.compareTo("") == 0) {
			valChamp = v;
			vue.miseAJour();	
			return true;
		}
		return false;
	}
		
	public Boolean getEditChamp() {
		return editChamp;
	}
	
	public void setEditChamp(final Boolean ed) {
		//Ctrl
		editChamp = ed;
//		valChamp="";
		vue.miseAJour();
	}

	public void setEnableChamp(final Boolean en){
		enableChamp = en;
		vue.miseAJour();
	}

	public Boolean getEnableChamp() {
		return enableChamp;
	}
	
	public void chgmtVal(String v) {
		for(ICompoChampNumObserver o : mesObserveurs) {
			o.changementValeur(v);
		}
	}
	
	public void chpVide() {
		for(ICompoChampNumObserver o : mesObserveurs) {
			o.champVide();
		}
	}
}
