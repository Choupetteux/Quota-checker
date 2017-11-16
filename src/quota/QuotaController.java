package quota;

import java.awt.Button;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class QuotaController {
	@FXML
	private Label progressLabel;
	@FXML
	private Button runButton;
	
	@FXML
	public void runButton(){
		this.progressLabel.setText("Traitement en cours...");
		this.runButton.setEnabled(true);
		
	
	}
	
}
