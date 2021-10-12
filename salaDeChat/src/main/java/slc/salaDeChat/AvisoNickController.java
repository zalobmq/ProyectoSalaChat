package slc.salaDeChat;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AvisoNickController {

	@FXML
    private Button Aceptar;
	
	protected void initialize() {
    	
    
	}
	@FXML
	private void aceptar() {
		try {
			App.setRoot("InicioSesion");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
