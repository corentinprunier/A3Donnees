package fr.ensma.a3.ia;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.ensma.a3.ia.listeners.EcouteurClavier;
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

public class ConvertisseurED extends Application implements EventHandler<ActionEvent> {

	private FlowPane root2;
	private VBox panBouton;
	private Button actConvert;
	private TextField champEntree, champSortie;
	private ComboBox<String> choixSens;

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Convertisseur Euros<->Dollars");

		// Implémentation selon l'arbre de construction graphique
		root2 = new FlowPane(Orientation.HORIZONTAL, 10, 10);
		root2.setMinWidth(600);
		root2.setAlignment(Pos.TOP_CENTER);
		champEntree = new TextField();
		root2.getChildren().add(champEntree);

		panBouton = new VBox(20);
		panBouton.setAlignment(Pos.TOP_CENTER);
		choixSens = new ComboBox<>();
		choixSens.getItems().addAll("Dollars->Euros", "Euros->Dollars");
		choixSens.getSelectionModel().select(0);
		actConvert = new Button("Conversion !!!");
		panBouton.getChildren().addAll(choixSens, actConvert);
		root2.getChildren().addAll(panBouton);

		champSortie = new TextField();
		champSortie.setEditable(false);
		champSortie.setDisable(true);
		root2.getChildren().addAll(champSortie);
		Scene scene = new Scene(root2, 600, 100);

		primaryStage.setScene(scene);
		// Limite le redimensionnement
		primaryStage.setMinWidth(600);
		primaryStage.setMinHeight(120);

		// Événements : -> Abonnements
		actConvert.addEventHandler(ActionEvent.ACTION, this);
		choixSens.addEventHandler(ActionEvent.ACTION, this);
		//Implémentation anonyme	
		actConvert.addEventFilter(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				logger.info("Filtre : Réaction !!!");
			}
		});
		
		root2.addEventFilter(KeyEvent.KEY_TYPED, new EcouteurClavier(this));
		root2.addEventFilter(KeyEvent.KEY_TYPED, new EcouteurInterne());

		primaryStage.show();
	}

	public static void main(String[] args) {

		launch(args);
	}

	public void resetChampTexte() {
		champEntree.setText("");
		champSortie.setText("");
	}

	@Override
	public void handle(ActionEvent event) {
		if (event.getSource() == choixSens) {
			logger.info("Action choisie : " + choixSens.getValue() + "("
					+ choixSens.getSelectionModel().getSelectedIndex() + ")");
		}
		if (event.getSource() == actConvert) {
			logger.info("Demande de conversion !");
		}
	}

	//Classe ecouteur interne
	private class EcouteurInterne implements EventHandler<KeyEvent> {

		public EcouteurInterne() {}

		@Override
		public void handle(KeyEvent event) {
			if (event.getCharacter().compareTo("A") == 0) {
				logger.info("Depuis l'ecouteur Interne");
				resetChampTexte();
				event.consume();
			}
		}
	}
	
	private static Logger logger = LogManager.getLogger(ConvertisseurED.class);
}
