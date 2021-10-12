package slc.salaDeChat;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelos.Usuario;

public class InicioSesionController {

    @FXML
    private TextField NickName;
    @FXML
    private Button BotonEntrar;
    
    @FXML
	protected void initialize() {
    	
	}
    
    public Usuario crearUsuario() {					//Crea un usuario con el nick introducido
    	String nickUsuario=NickName.getText();
    	Usuario u = new Usuario(nickUsuario);
    	return u;
    }
    
    protected Set<Usuario>  listaUsuarios(){		//Guarda el usuario que se conecta en una lista 
    	Set<Usuario> lista = new HashSet<Usuario>();
    	lista.add(crearUsuario());
    	return lista;
    }
    
    
    
    @FXML
    private void inicioSesion() {				
    	
    		if(NickName.getText().length() == 0) {
    			//PANTALLA DE AVISO --Rellene el campo NickName--
    			try {
					App.setRoot("VentanaAvisoNick");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}else {
    			//Carga la siguiente vista
    			try {
    	        	ElegirSalaController.setUsuario(crearUsuario());
    				//App.loadScene(new Stage(), "ElegirSala", "ELIJA UNA SALAs");
    	    		App.setRoot("ElegirSala");
    	    		

    			} catch (IOException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    			
    		}
    		
    		
    	
    }
    
    
}
