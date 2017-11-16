package quota;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class QuotaController {
	@FXML
	private Label progressLabel;
	@FXML
	private Button runButton;
	@FXML
	private ProgressBar progressBar;
	
	@FXML
	public void onRun(){
		this.progressLabel.setText("Traitement en cours...");
		this.progressBar.setProgress(-1);
		this.runButton.setDisable(true);
		DirectoryLister dir = new DirectoryLister(System.getProperty("user.home"));
		dir.list();
		
		
	}
	
}
