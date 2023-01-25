package fr.ensma.a3.ia.convdevisesui.mvc.compoaction;

import fr.ensma.a3.ia.convdevisesui.mvc.compoaction.etats.EtatAllDisable;
import fr.ensma.a3.ia.convdevisesui.mvc.compoaction.etats.EtatAllEnable;
import fr.ensma.a3.ia.convdevisesui.mvc.compoaction.etats.EtatButtonEnable;
import fr.ensma.a3.ia.convdevisesui.mvc.compoaction.etats.EtatComboEnable;
import fr.ensma.a3.ia.convdevisesui.mvc.compoaction.etats.IAutomate;
import fr.ensma.a3.ia.convdevisesui.mvc.compoaction.etats.IEtat;
import fr.ensma.a3.ia.convdevisesui.mvc.compoaction.etats.TransitionException;

public class ControlAction implements IAutomate {

	private ModelAction modelCompo;
	private VueAction vueCompo;
	
	private IEtat etatCourant;
	private IEtat etatAllEnable;
	private IEtat etatAllDisable;
	private IEtat etatComboEnable;
	private IEtat etatButtonEnable;
	
	public ControlAction(final ModelAction mod) {
		modelCompo = mod;
		vueCompo = new VueAction(modelCompo, this);
		etatAllEnable = new EtatAllEnable(this);
		etatAllDisable = new EtatAllDisable(this);
		etatComboEnable = new EtatComboEnable(this);
		etatButtonEnable = new EtatButtonEnable(this);
		etatCourant = etatAllDisable;
		vueCompo.setDisableButton(true);
		vueCompo.setDisableCombo(true);
	}
	
	public final VueAction getVue() {
		return vueCompo;
	}

	@Override
	public void setEtatCourant(IEtat etat) {
		etatCourant = etat;
	}

	@Override
	public IEtat getEtatAllEnable() {
		return etatAllEnable;
	}

	@Override
	public IEtat getEtatAllDisable() {
		return etatAllDisable;
	}

	@Override
	public IEtat getEtatButtonEnable() {
		return etatButtonEnable;
	}

	@Override
	public IEtat getEtatComboEnable() {
		return etatComboEnable;
	}
	
	public void clickButton() {
		try {
			etatCourant.click();
			//Modelepour Observateur
			modelCompo.notifyObsClick();
		} catch (TransitionException ex) {
			//ex.printStackTrace();
		}
	}
	
	public void chgtSelection() {
		try {
			etatCourant.chgtSelection();
			//Modelepour Observateur
			modelCompo.setSelection(
					vueCompo.getSelection());
			modelCompo.setIndexSelection(
					vueCompo.getSelectionIndex());
			modelCompo.notifyObsChgmtSelection();
		} catch (TransitionException ex) {
			//ex.printStackTrace();
		}
	}
	
	public void enableSelection() {
		try {
			etatCourant.eCombo();
			vueCompo.setDisableCombo(false);
		} catch (TransitionException ex) {
			//ex.printStackTrace();
		}
	}
	
	public void enableAction() {
		try {
			etatCourant.eButton();
			vueCompo.setDisableButton(false);
		} catch (TransitionException ex) {
			//ex.printStackTrace();
		}
	}

	public void disableSelection() {
		try {
			etatCourant.dCombo();
			vueCompo.setDisableCombo(true);
		} catch (TransitionException ex) {
			//ex.printStackTrace();
		}
	}
	
	public void disableAction() {
		try {
			etatCourant.dButton();
			vueCompo.setDisableButton(true);
		} catch (TransitionException ex) {
			//ex.printStackTrace();
		}
	}

	
}
