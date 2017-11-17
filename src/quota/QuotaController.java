package quota;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
	
	public static final ExecutorService backgroundPool = Executors.newSingleThreadExecutor();
	
	@FXML
	public void onRun(){
		DirectoryLister dir = new DirectoryLister(System.getProperty("user.home"));
		
		backgroundPool.submit(new Runnable() {
			@Override
			public void run() {
				dir.list();
			}
		});
		this.progressLabel.setText("Traitement en cours...");
		this.progressBar.setProgress(-1);
		this.runButton.setDisable(true);
	}
	
    @Override
    public void stop() throws Exception {
       super.stop();
       backgroundPool.shutdown();
    }
	
}
