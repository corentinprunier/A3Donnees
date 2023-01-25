package fr.ensma.a3.ia.convdevisesui;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.ensma.a3.ia.convdevisesbusinessapi.FabriqueConvertisseur;
import fr.ensma.a3.ia.convdevisesbusinessapi.IBaseConvertisseur;
import fr.ensma.a3.ia.convdevisesui.listeners.EcouteurClavier;
import fr.ensma.a3.ia.convdevisesui.mvc.champnum.ChampNumModele;
import fr.ensma.a3.ia.convdevisesui.mvc.compoaction.ICompoActionObserver;
import fr.ensma.a3.ia.convdevisesui.mvc.compoaction.ModelAction;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ConvertisseurEDMvc extends Application implements ICompoActionObserver {

	private FlowPane root2;
	
	//Composant MVC Action
	private ModelAction compoAction;
	private ChampNumModele chEntree, chpSortie;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Convertisseur Euros<->Dollars");

		// Implémentation selon l'arbre de construction graphique
		root2 = new FlowPane(Orientation.HORIZONTAL, 10, 10);
		root2.setMinWidth(600);
		root2.setAlignment(Pos.TOP_CENTER);
		
		chEntree = new ChampNumModele(true, true, "Valeur :");
		root2.getChildren().addAll(chEntree.getVue());
		
		
		compoAction = new ModelAction();
		root2.getChildren().addAll(compoAction.getVue());
		compoAction.setButtonLabel("La girafe ...");
		compoAction.addObserver(this);
		compoAction.enableSelection();
		ArrayList<String> mod = new ArrayList<String>();
		mod.add("Pique");
		mod.add("Nique");
		mod.add("Douille");
		compoAction.setComboModel(mod);
		
		chpSortie = new ChampNumModele(false, false, "Résultat");
		root2.getChildren().add(chpSortie.getVue());
		
		Scene scene = new Scene(root2, 600, 100);

		primaryStage.setScene(scene);
		// Limite le redimensionnement
		primaryStage.setMinWidth(600);
		primaryStage.setMinHeight(120);
			
		primaryStage.show();
	}

	public static void main(String[] args) {

		launch(args);
	}

	private static Logger logger = LogManager.getLogger(ConvertisseurEDMvc.class);

	@Override
	public void notifyClick() {
		System.out.println("Y a un CLick !");
	}

	@Override
	public void notifyChgmtSelection() {
		System.out.println("Y a un chgmt de selection : " + compoAction.getSelection() );
	}
}
