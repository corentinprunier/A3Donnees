package fr.ensma.a3.ia.convdevisesui.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import fr.ensma.a3.ia.convdevisesui.mvc.champnum.ChampNumModele;
import fr.ensma.a3.ia.convdevisesui.mvc.champnum.ICompoChampNumObserver;
import fr.ensma.a3.ia.convdevisesui.mvc.compoaction.ICompoActionObserver;
import fr.ensma.a3.ia.convdevisesui.mvc.compoaction.ModelAction;
import fr.ensma.a3.ia.convdevisesbusinessapi.FabriqueConvertisseur;
import fr.ensma.a3.ia.convdevisesbusinessapi.IBaseConvertisseur;

public class ConvertisseurMVCModele implements ICompoActionObserver, ICompoChampNumObserver {

	private List<String> listeChoix;
	private int selectIndex;
	private ModelAction panneauAction;
	private ChampNumModele champNumEntree, champNumSortie;
	private ConvertisseurMVCVue maVue;
	private ConvertisseurMVCCtrl monCtrl;
	// Noyau Fonctionnel
	// Todo -> Lien vers la couche Business API via la Fabrique
	private FabriqueConvertisseur fabConv;
	private IBaseConvertisseur leConv;

	private static Logger LOGGER = Logger.getLogger(ConvertisseurMVCModele.class.getName());

	public ConvertisseurMVCModele(ConvertisseurMVCVue v, ConvertisseurMVCCtrl c) {
		maVue = v;
		monCtrl = c;
		listeChoix = new ArrayList<String>();
		listeChoix.add("Dollars->Euros");
		listeChoix.add("Euros->Dollars");
		selectIndex = 0;
		// Instanciation en utilisant la Fabrique
		fabConv = new FabriqueConvertisseur();
		leConv = fabConv.fabriqueBaseConvertisseur();
	}

	public List<String> getListeChoix() {
		return listeChoix;
	}

	public void setModels(ChampNumModele chpe, ModelAction act, ChampNumModele chps) {
		panneauAction = act;
		champNumEntree = chpe;
		champNumSortie = chps;
		panneauAction.addObserver(this);
		champNumEntree.ecouteCompoChpNum(this);
	}

	public void initConvertisseur() {
		panneauAction.disableSelection();
		panneauAction.disableAction();
		champNumEntree.setEnableChamp(true);
		champNumEntree.setValChamp("");
		champNumSortie.setValChamp("");
	}

	public void convertOk() {
		panneauAction.enableSelection();
		panneauAction.enableAction();
	}

	public void doConvert() {
		// Appel au Noyau Fonctionnel
		/*
		 * champNumSortie.setValChamp(String.valueOf(noyauFonc.convertDollarToEuro(
		 * Double.valueOf(champNumEntree.getValChamp()))));
		 */

		if (selectIndex == 0) {
			champNumSortie.setValChamp(leConv.convertDollarToEuro(Double.valueOf(champNumEntree.getValChamp())).toString());
		} else {
			champNumSortie.setValChamp(leConv.convertEuroToDollar(Double.valueOf(champNumEntree.getValChamp())).toString());
		}

		panneauAction.disableSelection();
		panneauAction.disableAction();
		champNumEntree.setEnableChamp(false);
	}

	@Override
	public void changementValeur(String val) {
		monCtrl.changementValeur();
	}

	@Override
	public void champVide() {
		monCtrl.champEntreeVide();
	}

	@Override
	public void notifyChgmtSelection() {
		selectIndex = panneauAction.getIndexSelection();
		LOGGER.info("Chamgement selection : " + listeChoix.get(selectIndex));
	}

	@Override
	public void notifyClick() {
		monCtrl.demandeAction();
	}

}
