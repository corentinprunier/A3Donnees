package fr.ensma.a3.ia.convdevisesui.mvc.compoaction;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;

public class VueAction extends VBox implements EventHandler<ActionEvent>{

	private ModelAction modelCompo;
	private ControlAction controlCompo;
	
	private ComboBox<String> choixSens;
	private Button actConvert;
	
	public VueAction (final ModelAction mod, final ControlAction ctrl) {
		super(20);
		modelCompo = mod;
		controlCompo = ctrl;
		setAlignment(Pos.TOP_CENTER);
		choixSens = new ComboBox<>();
		//choixSens.getItems().addAll("");
		//choixSens.getSelectionModel().select(0);
		actConvert = new Button();
		getChildren().addAll(choixSens, actConvert);
		choixSens.addEventHandler(ActionEvent.ANY, this);
		actConvert.addEventHandler(ActionEvent.ANY,	this);
	}

	@Override
	public void handle(ActionEvent event) {
		if (event.getSource() == choixSens) {
			controlCompo.chgtSelection();
		}
		if (event.getSource() == actConvert) {
			controlCompo.clickButton();
		}	
	}
	
	public void setDisableButton(final Boolean state) {
		actConvert.setDisable(state);
	}
	
	public void setDisableCombo(final Boolean state) {
		choixSens.setDisable(state);
	}
	
	public void fireUpdate() {
		//MaJ Bouton
		actConvert.setText(
				modelCompo.getButtonLabel()
				);
		//MaJ Combo
		choixSens.getItems().setAll(modelCompo.getComboModel());
		choixSens.getSelectionModel().select(0);
	}
	
	public String getSelection() {
		return choixSens.getSelectionModel().getSelectedItem();
	}

	public int getSelectionIndex() {
		return choixSens.getSelectionModel().getSelectedIndex();
	}
	
}
