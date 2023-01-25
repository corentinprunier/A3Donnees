package fr.ensma.a3.ia.convdevisesui.mvc;

import fr.ensma.a3.ia.convdevisesui.mvc.champnum.ChampNumModele;
import fr.ensma.a3.ia.convdevisesui.mvc.compoaction.ModelAction;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ConvertisseurMVCVue extends Application implements EventHandler<KeyEvent> {

	private FlowPane root2;
	
	private ModelAction panneauAction;
	private ChampNumModele champNumEntree, champNumSortie;
	
	private ConvertisseurMVCModele monModel;
	private ConvertisseurMVCCtrl monCtrl;
	
	@Override
	public void start(Stage primaryStage) {
		initComposant();
		primaryStage.setTitle("Convertisseur Euros<->Dollars");
		root2 = new FlowPane(Orientation.HORIZONTAL,10, 10);
		root2.setMinWidth(600);
		root2.setAlignment(Pos.TOP_CENTER);
		root2.getChildren().add(champNumEntree.getVue());
		root2.getChildren().add(panneauAction.getVue());
		root2.getChildren().add(champNumSortie.getVue());
		primaryStage.addEventFilter(KeyEvent.KEY_TYPED, this);
		Scene scene = new Scene(root2, 600, 100);
		primaryStage.setScene(scene);
		primaryStage.setMinWidth(600);
		primaryStage.setMinHeight(120);
		primaryStage.show();
	}
	
	private void initComposant() {
		monCtrl = new ConvertisseurMVCCtrl(this);
		monModel = new ConvertisseurMVCModele(this,monCtrl);
		
		champNumEntree = new ChampNumModele(true, true, "Valeur à convertir ...");
		
		panneauAction = new ModelAction();
		panneauAction.setComboModel(monModel.getListeChoix());
		panneauAction.setButtonLabel("Conversion ...");
		//panneauAction.activeAll(true);
		
		champNumSortie = new ChampNumModele(false,false,"Valeur convertie");
		
		monModel.setModels(champNumEntree, panneauAction, champNumSortie);
		monCtrl.setModel(monModel);
	}

	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void handle(KeyEvent event) {
		if (event.getCharacter().compareTo("A")==0) {
			monCtrl.toucheA();
			event.consume();
		}
	}
}
