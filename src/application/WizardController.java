package application;

import java.io.IOException;
import java.util.LinkedList;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.*;
import javafx.util.Duration;

public class WizardController {

	@FXML
	private AnchorPane root, pane1, pane2, pane3;
	
	@FXML
	private Label slide, slide3, descripcion;
	
	private int countPane;
	private final double duracionTranslate = 0.5;
	private final double desplazamiento = 600;

	public void initialize() {
		movePanes();
		countPane = 1;
		slide.setText("Empieza a comer natural");
	}

	private void movePanes() {
		translateAnimation(0.1, pane2, desplazamiento);
		translateAnimation(0.1, pane3, desplazamiento);

	}

	public void translateAnimation(double duration, Node node, double byX) {

		TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(duration), node);
		translateTransition.setByX(byX);
		translateTransition.play();

	}

	@FXML
	public void nextPane() {
		switch (countPane) {
		case 1:
			translateAnimation(duracionTranslate, pane2, -desplazamiento);
			slide.setText("Conviertete en el mejor cocinero de tu hogar");
			descripcion.setText("Saber cocinar es muy importante ya que nos hace más felices y nos ayuda a desarrollar nuestra creatividad");
			//slide2.setImage(new Image("./img/wizard/panadero.png"));
			slide3.setText("2/3");
			countPane++;
			break;
		case 2:
			translateAnimation(duracionTranslate, pane3, -desplazamiento);
			slide.setText("Haz de tu cocina un templo");
			descripcion.setText("Con esta aplicación no volveras a ver tu cocina con los mismos ojos, se acabo llamarla \"la sala que siempre se ensucia\"");
			slide3.setText("3/3");
			countPane++;
			break;

		default:
			System.out.println("No hay mas");
			break;
		}
	}

	@FXML
	public void lastPane() {
		switch (countPane) {
		case 3:
			translateAnimation(duracionTranslate, pane3, desplazamiento);
			slide.setText("Conviertete en el mejor cocinero de tu hogar");
			descripcion.setText("Saber cocinar es muy importante ya que nos hace más felices y nos ayuda a desarrollar nuestra creatividad");
			//slide2.setImage(new Image("../img/wizard/panadero.png"));
			slide3.setText("2/3");
			
			countPane--;
			break;
		case 2:
			translateAnimation(duracionTranslate, pane2, desplazamiento);
			slide.setText("Empieza a comer natural");
			descripcion.setText("Unete a la lucha por una alimentación saludable");
			//slide2.setImage(new Image("../img/wizard/verduras.png"));
			slide3.setText("1/3");
			countPane--;
			break;

		default:
			System.out.println("No hay mas");
			break;
		}
	}

	@FXML
	public void closeWizard() {
		Stage thisStage = (Stage) root.getScene().getWindow();
		thisStage.close();

		try {
			// Load the fxml file and create a new stage for the popup.
			FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
			AnchorPane root = (AnchorPane) loader.load();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.initStyle(StageStyle.UNDECORATED);
			stage.setScene(scene);
			stage.show();
			System.out.println("second stage ok");

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("second stage ko");
		}
	}
}
