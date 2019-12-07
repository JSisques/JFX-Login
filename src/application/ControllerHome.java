package application;

import java.util.LinkedList;
import java.util.Queue;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BackgroundImage;
import javafx.util.Duration;

/**
 * 
 * @author javi
 *
 */
public class ControllerHome {

	private boolean navClosed;
	private Queue<String> backgroundImg;

	@FXML
	private AnchorPane rootPane, fondo, nav, opacityPane;

	public void initialize() {

		backgroundImg = new LinkedList<String>();

		backgroundImg.add("-fx-background-image: url(\"../../img/home/1.jpg\");");
		backgroundImg.add("-fx-background-image: url(\"../../img/home/2.jpg\");");
		backgroundImg.add("-fx-background-image: url(\"../../img/home/3.jpg\");");
		backgroundImg.add("-fx-background-image: url(\"../../img/home/4.jpg\");");

		hideNav();
		disabledOpacityPane();

		slider();

	}
	
	/**
	 * Metodo para desactivar el panel
	 */

	private void disabledOpacityPane() {
		FadeTransition ft = new FadeTransition(Duration.seconds(0.1), opacityPane);
		ft.setFromValue(1);
		ft.setToValue(0.1);
		ft.play();
		opacityPane.setVisible(false);

	}

	
	/**
	 * Metodo para activar la animación Fade
	 */
	
	private void showFadeAnimation() {
		FadeTransition ft = new FadeTransition(Duration.seconds(0.4), opacityPane);
		ft.setFromValue(0.1);
		ft.setToValue(0.75);
		opacityPane.setVisible(true);
		ft.play();
	}

	private void hideFadeAnimation() {
		FadeTransition ft = new FadeTransition(Duration.seconds(0.4), opacityPane);
		ft.setFromValue(0.75);
		ft.setToValue(0.1);
		opacityPane.setVisible(false);
		ft.play();
	}

	/**
	 * Metodo para esconder el menu
	 * 
	 */
	private void hideNav() {
		TranslateTransition tt = new TranslateTransition(Duration.seconds(0.1), nav);
		tt.setByX(-500);
		tt.play();

		navClosed = true;
	}
	
	
	/**
	 * Metodo que se encarga de esconder o mostrar el menu
	 */

	@FXML
	private void navAction() {
		TranslateTransition tt = new TranslateTransition(Duration.seconds(0.3), nav);

		if (navClosed) {
			tt.setByX(500);
			tt.play();
			showFadeAnimation();
			navClosed = false;
		} else {
			tt.setByX(-500);
			tt.play();
			hideFadeAnimation();
			navClosed = true;
		}

	}
	
	/**
	 * Metodo para controlar el slider
	 */

	private void slider() {
		String img = backgroundImg.poll();
		FadeTransition ft = new FadeTransition(Duration.seconds(0.4), opacityPane);
		ft.setFromValue(1);
		ft.setToValue(0.1);
		ft.play();
		fondo.setStyle(img);
		backgroundImg.add(img);
	}

}
