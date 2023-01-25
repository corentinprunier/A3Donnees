package fr.ensma.a3.ia.convdevisesui.mvc.champnum;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;

public class ChampNumVue extends VBox implements EventHandler<KeyEvent> {

	private Label labChT;
	private TextField txtF;
	
	private ChampNumCtrl ctrl;
	private ChampNumModele mod;
	
	public ChampNumVue(final ChampNumCtrl c, final ChampNumModele m) {
		ctrl = c;
		mod = m;
		labChT = new Label(mod.getLeLabel());
		txtF = new TextField();
		txtF.setEditable(mod.getEditChamp());
		txtF.setDisable(!mod.getEnableChamp());
		getChildren().addAll(labChT, txtF);
		setMinWidth(200d);
		labChT.setAlignment(Pos.CENTER);
		txtF.addEventFilter(KeyEvent.KEY_TYPED, this);
		txtF.setText("");
	}
	
	public void miseAJour() {
		labChT.setText(mod.getLeLabel());
		txtF.setText(mod.getValChamp());
		txtF.setEditable(mod.getEditChamp());
		txtF.setDisable(!mod.getEnableChamp());
	}
	
	@Override
	public void handle(KeyEvent event) {
		ctrl.actionTouche(txtF.getText()+event.getCharacter().toString());
		event.consume();
		if(txtF.getText()!=null) {
			txtF.positionCaret(txtF.getText().length());
		}
	}
}
