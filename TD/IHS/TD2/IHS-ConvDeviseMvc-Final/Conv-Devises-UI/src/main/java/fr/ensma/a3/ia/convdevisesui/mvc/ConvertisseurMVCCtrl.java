package fr.ensma.a3.ia.convdevisesui.mvc;

import fr.ensma.a3.ia.convdevisesui.mvc.automate.EtatChampENonVide;
import fr.ensma.a3.ia.convdevisesui.mvc.automate.EtatChampEVide;
import fr.ensma.a3.ia.convdevisesui.mvc.automate.EtatChampSNonVide;
import fr.ensma.a3.ia.convdevisesui.mvc.automate.GlobalTransitionNonTirableException;
import fr.ensma.a3.ia.convdevisesui.mvc.automate.IEtatGlobal;

public class ConvertisseurMVCCtrl {

	private ConvertisseurMVCModele mod;
	private ConvertisseurMVCVue vue;
	
	private IEtatGlobal etatCourant;
	private IEtatGlobal etatChampEVide = new EtatChampEVide(this);
	private IEtatGlobal etatChampENonVide = new EtatChampENonVide(this);
	private IEtatGlobal etatChampSNonVide = new EtatChampSNonVide(this);
	
	public ConvertisseurMVCCtrl(ConvertisseurMVCVue v) {
		vue = v;
	}
	
	public void setModel(ConvertisseurMVCModele m) {
		mod = m;
		mod.initConvertisseur();
		etatCourant = etatChampEVide;
	}
	
	public void toucheA() {
		try {
			etatCourant.toucheA();
			mod.initConvertisseur();
		} catch (GlobalTransitionNonTirableException e) {
			System.out.println("Touche A inactive dans cet état ...");
		}
	}
	
	void champEntreeVide() {
		try {
			etatCourant.champEntreeVide();
			mod.initConvertisseur();
		} catch (GlobalTransitionNonTirableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void changementValeur() {
		try {
			etatCourant.changementValeur();
			mod.convertOk();
		} catch (GlobalTransitionNonTirableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void demandeAction() {
		try {
			etatCourant.demandeAction();
			mod.doConvert();
		} catch (GlobalTransitionNonTirableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setEtatCourant(IEtatGlobal etat) {
		etatCourant = etat;
	}
	
	public IEtatGlobal getEtatChampEVide() {
		return etatChampEVide;
	}
	
	public IEtatGlobal getEtatChampENonVide() {
		return etatChampENonVide;
	}
	
	public IEtatGlobal getEtatChampSNonVide() {
		return etatChampSNonVide;
	}
}
