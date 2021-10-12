package utilidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import modelos.Usuario;

public class Utilidades {

	public static List<Usuario> SetAListUsuarios(Set<Usuario> usuarios) {
        return new ArrayList<>(usuarios);
    }
	
	public static void MostrarError( String titulo, String cabecera, String descripcion) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle(titulo);
        alert.setHeaderText(cabecera);
        alert.setContentText(descripcion);
        alert.showAndWait();
    }
}
