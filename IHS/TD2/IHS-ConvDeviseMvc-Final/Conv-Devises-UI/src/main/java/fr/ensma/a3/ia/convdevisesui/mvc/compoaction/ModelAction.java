package fr.ensma.a3.ia.convdevisesui.mvc.compoaction;

import java.util.ArrayList;
import java.util.List;

public class ModelAction {

	private VueAction vueCompo;
	private ControlAction controlCompo;
	
	//Observer
	private List<ICompoActionObserver> abonnes;

	//Modelisation graphique
	private String buttonLabel;
	private List<String> comboModel;
	private String selection;
	private int selectIndex;
	
	
	public ModelAction() {
		controlCompo = new ControlAction(this);
		vueCompo = controlCompo.getVue();
		abonnes = new ArrayList<ICompoActionObserver>();
		comboModel = new ArrayList<String>();
	}
	
	public final VueAction getVue() {
		return vueCompo;
	}

	public void setButtonLabel(final String lab) {
		buttonLabel = lab;
		vueCompo.fireUpdate();
	}
	
	public String getButtonLabel() {
		return buttonLabel;
	}
	
	public List<String> getComboModel() {
		return comboModel;
	}
	
	public void setComboModel(final List<String> mod) {
		comboModel = mod;
		vueCompo.fireUpdate();
	}
	
	public String getSelection() {
		return selection;
	}
	
	public int getIndexSelection() {
		return selectIndex;
	}
	
	public void setSelection(final String sel) {
		selection = sel;
	}
	
	public void setIndexSelection(final int ind) {
		selectIndex = ind;
	}
	
	public void addObserver(final ICompoActionObserver obs) {
		abonnes.add(obs);
	}
	
	public void removeObserver(final ICompoActionObserver obs) {
		abonnes.remove(obs);
	}
	
	public void notifyObsClick() {
		for (ICompoActionObserver abo : abonnes) {
			abo.notifyClick();
		}
	}
	
	public void notifyObsChgmtSelection() {
		for (ICompoActionObserver abo : abonnes) {
			abo.notifyChgmtSelection();
		}
	}
	
	public void enableSelection() {
		controlCompo.enableSelection();		
	}
	
	public void enableAction() {
		controlCompo.enableAction();
	}
	
	public void disableSelection() {
		controlCompo.disableSelection();		
	}
	
	public void disableAction() {
		controlCompo.disableAction();
	}
}
