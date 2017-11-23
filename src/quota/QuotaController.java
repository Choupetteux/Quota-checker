package quota;
import java.util.Comparator;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;

public class QuotaController {
	@FXML
	private Label progressLabel;
	@FXML
	private Button runButton;
	@FXML
	private ProgressBar progressBar;
	@FXML
	private ListView<FileItem> fileList;

	@FXML
	public void onRun() throws InterruptedException, ExecutionException{
		DirectoryLister dir = new DirectoryLister("/usr/share/icons");
		Observer obs = new Observer(){

			@Override
			public void update(Observable o, Object arg) {
				ProgressEvent progr = (ProgressEvent) arg;
				Platform.runLater(new Runnable(){
					@Override
					public void run() {
						progressLabel.setText((progr.totalSize / (1024*1024)) + " / 400 Mio");
						double progress = ((progr.totalSize.doubleValue() / (1024*1024)) / 400);
						progressBar.setProgress(progress);
						fileList.getItems().add(progr.getFileItem());

						fileList.getItems().sort(new Comparator<FileItem>(){

							@Override
							public int compare(FileItem o1, FileItem o2) {
								if(o1.getSize() < o2.getSize()){
									return 1;
								}
								else if(o1.getSize() > o2.getSize()){
									return -1;
								}
								else{
									return 0;
								}
							}
						});
					}
				});

			}
		};

		dir.addObserver(obs);
		this.progressLabel.setText("Traitement en cours...");
		this.progressBar.setProgress(-1);
		this.runButton.setDisable(true);

		Main.backgroundPool.submit(new Runnable() {
			@Override
			public void run() {

				Long size = dir.list();

				Platform.runLater(new Runnable(){
					@Override
					public void run() {
						progressLabel.setText((size / (1024 * 1024)) + " / 400 Mio");
						double progress = ((size.doubleValue() / (1024*1024)) / 400);
						progressBar.setProgress(progress);
						runButton.setDisable(false);
					}
				});


			}
		});


	}

}
