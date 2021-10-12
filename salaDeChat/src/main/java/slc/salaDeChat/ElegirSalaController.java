package slc.salaDeChat;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import jakarta.xml.bind.JAXBException;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import modelos.Sala;
import modelos.SalaDAO;
import modelos.Usuario;


public class ElegirSalaController {

	
	List<Sala> listaSala;
	
	@FXML
	private Button EntrarSala1;
	@FXML
	private Button EntrarSala2;
	private static Usuario usuario;
	
	//-------------------------------------------------
	
	@FXML
    private Label NickInicioSesion;
	
	//-------------------------------------------------

	@FXML
	private TableView<Sala> salas;
	
	//-------------------------------------------------
	
	@FXML
    private TableColumn<Sala, String> sala;

    @FXML
    private TableColumn<Sala, String> numeroDeUsuarios;
    
	//-------------------------------------------------
    
    @FXML
	protected void initialize() {
    configurarTabla();
    escribirEnLabel(usuario);
    listaSala=new ArrayList<Sala>();
	    try {
			listaSala.add(SalaDAO.unmarshal(new File("SALA1.xml")));
			listaSala.add(SalaDAO.unmarshal(new File("SALA2.xml")));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	 salas.setItems(FXCollections.observableArrayList(listaSala));
	 salas.refresh();
	 
	}
    

    private void configurarTabla() {
    	
    	sala.setCellValueFactory(cadaSala-> new SimpleStringProperty(cadaSala.getValue().getNombre()));
    	numeroDeUsuarios.setCellValueFactory(cadaSala->
    	new SimpleStringProperty(cadaSala.getValue().getUsuariosConectados().size()+""));
    
    }
    
    //------- Botones entrar sala 
    @FXML
    private void entrarSala1() {
	    try {
	    	Sala1Controller.setSala(listaSala.get(0) , usuario);
			App.loadScene(new Stage(), "Sala1", " Sala 1 ");
			
			//App.setRoot("Sala1");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
    }
    
    @FXML
    private void entrarSala2() {
	    try {
	    	Sala2Controller.setSala(listaSala.get(1) , usuario);
			App.loadScene(new Stage(), "Sala2", " Sala 2 ");
			//App.setRoot("Sala2");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
    }
    
    
    private void escribirEnLabel (Usuario u) {
    
        	NickInicioSesion.setText(u.getNick());
    	
    }
    
    public static void setUsuario (Usuario u) {
	
    	usuario = u;
    	
    }
   
}

