package slc.salaDeChat;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import java.util.Timer;
import java.util.TimerTask;
import jakarta.xml.bind.JAXBException;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.application.Platform;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelos.Mensaje;
import modelos.Sala;
import modelos.SalaDAO;
import modelos.Usuario;
import utilidades.Utilidades;

public class Sala1Controller {

	private static Sala salaActual;
	private static Usuario usuarioActual;
	private static Timer t;
	
	@FXML
    private TextField textFielChat;
    
	//-------------------------------------------------

	@FXML
	private TableView<Mensaje> tablaChat;
	//-------------------------------------------------
	@FXML
    private TableColumn<Mensaje, String> nick;
    @FXML
    private TableColumn<Mensaje, String> texto;
    @FXML
    private TableColumn<Mensaje, String> tiempo;
    
    
	//-------------------------------------------------
    
    
    @FXML
	private TableView<Usuario> tablaUsuarios;
	//-------------------------------------------------
    @FXML
    private TableColumn<Usuario, String> usuariosConectados;
    
	@FXML
	protected void initialize() {
		t = new Timer();
		t.schedule(new TimerTask() {
			
			@Override
			public void run() {
				
				Platform.runLater(() -> {
					try {
						salaActual = SalaDAO.unmarshal(new File("SALA1.xml"));
						
						for(Usuario u :salaActual.getUsuariosConectados()) {
							if(u.getNick().equals(usuarioActual.getNick())) {
								salaActual.getUsuariosConectados().remove(u);
								break;
							}
						}
						
						salaActual.getUsuariosConectados().add(usuarioActual);
						
						refrescarMensajes();
						refrescarUsuariosOnline();
					} catch (JAXBException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});

			}
		}, 0,5000);
		configurarTabla();
		salaActual.getUsuariosConectados().add(usuarioActual);
		refrescarMensajes();
		refrescarUsuariosOnline();
	}
	
	public static void setSala(Sala s , Usuario u) {
		salaActual = s;
		usuarioActual = u;
		
	}
	
	private void configurarTabla() {
    	
    	nick.setCellValueFactory(cadaMensaje -> new SimpleStringProperty(cadaMensaje.getValue().getUsuario().getNick()));
    	texto.setCellValueFactory(cadaMensaje -> new SimpleStringProperty(cadaMensaje.getValue().getTexto()));
    	tiempo.setCellValueFactory(cadaMensaje -> new SimpleStringProperty(cadaMensaje.getValue().getFecha().toString()));
    	//-------
    	usuariosConectados.setCellValueFactory(cadaUsuario -> new SimpleStringProperty(cadaUsuario.getValue().getNick()));
    }
	@FXML
	private void enviar() {
		Mensaje mE = new Mensaje(usuarioActual, LocalDateTime.now().toString() ,textFielChat.getText());
		salaActual.getMensajes().add(mE);
		refrescarMensajes();
		tablaChat.scrollTo(mE);
		textFielChat.clear();
			try {
				SalaDAO.marshal(salaActual, new File("SALA1.xml"));
			} catch (IOException | JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	private void refrescarMensajes() {
		
		tablaChat.setItems(FXCollections.observableList(salaActual.getMensajes()));
		tablaChat.refresh();
	}
	private void refrescarUsuariosOnline() {
		
		tablaUsuarios.setItems(FXCollections.observableArrayList(Utilidades.SetAListUsuarios(salaActual.getUsuariosConectados())));
		tablaUsuarios.refresh();
	}
	
	@FXML
	private void salir() {	
		salaActual.getUsuariosConectados().remove(usuarioActual);
		try {
			SalaDAO.marshal(salaActual, new File("SALA1.xml"));
			t.purge();
			t.cancel();
		} catch (IOException | JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			Stage A = (Stage) textFielChat.getScene().getWindow();
			A.close();
			//App.loadScene(new Stage(), "InicioSesion", " InicioSesion ");
	}
}
