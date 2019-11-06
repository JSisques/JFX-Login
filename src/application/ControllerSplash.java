package application;

import java.io.IOException;

import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class ControllerSplash {

	@FXML
	private AnchorPane rootPane;

	@FXML
	private ImageView imgLogo;

	@FXML
	private VBox loginContainer;

	@FXML
	private Label name;

	@FXML
	private Label eslogan;

//	Main main;
//	Stage stage;
//
//	public void main(Stage stage, Main main) {
//		this.main = main;
//		this.stage = stage;
//	}

	public void showLogin() {
		try {
			// Load the fxml file and create a new stage for the popup.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("main.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage homeStage = new Stage();
			Scene scene = new Scene(page);
			homeStage.initStyle(StageStyle.UNDECORATED);
			homeStage.setScene(scene);
			homeStage.setMaximized(true);
			homeStage.show();
			System.out.println("second stage ok");

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("second stage ko");
		}
	}

	public void initialize() {

		ScaleTransition ft = new ScaleTransition(Duration.seconds(0.1), imgLogo);
		ft.setFromX(0);
		ft.setFromY(0);
		ft.play();
		
		ft.setOnFinished(eventooo -> {
			ScaleTransition ft2 = new ScaleTransition(Duration.seconds(1), imgLogo);
			ft2.setToX(1);
			ft2.setToY(1);
			ft2.play();
			
			ft2.setOnFinished(eventooo2 -> {
				ScaleTransition st = new ScaleTransition(Duration.seconds(0.5), imgLogo);
				st.setByX(0.3);
				st.setByY(0.3);
				st.play();

				st.setOnFinished(evento1 -> {
					ScaleTransition st1 = new ScaleTransition(Duration.seconds(0.5), imgLogo);
					st1.setByX(-0.3);
					st1.setByY(-0.3);
					st1.play();

					st1.setOnFinished(evento2 -> {
						ScaleTransition st2 = new ScaleTransition(Duration.seconds(0.5), imgLogo);
						st2.setByX(0.3);
						st2.setByY(0.3);
						st2.play();

						st2.setOnFinished(evento3 -> {
							ScaleTransition st3 = new ScaleTransition(Duration.seconds(0.5), imgLogo);
							st3.setByX(-0.3);
							st3.setByY(-0.3);
							st3.play();

							st3.setOnFinished(evento4 -> {
								FadeTransition ft3 = new FadeTransition(Duration.seconds(1), imgLogo);
								ft3.setFromValue(1);
								ft3.setToValue(0);
								ft3.play();
								
								ft3.setOnFinished(evento5 -> {
									Stage thisStage = (Stage) rootPane.getScene().getWindow();
									thisStage.close();
									showLogin();

									System.out.println("Hecho");
								});
							});
						});
					});

				});
			});
		});
	}

}
