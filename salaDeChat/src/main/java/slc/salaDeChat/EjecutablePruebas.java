package slc.salaDeChat;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import jakarta.xml.bind.JAXBException;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import modelos.Mensaje;
import modelos.Sala;
import modelos.SalaDAO;
import modelos.Usuario;
public class EjecutablePruebas {

	public static void main(String[] args) {

		
	
	/*	
		File f=new File("Sala.xml");
		try {
			Sala usuarios = SalaDAO.unmarshal(f);
			for(Usuario u:usuarios.getUsuariosConectados()) {
				System.out.println("Usuario: "+u.getNick());
			}
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	*/
		/*
		Usuario u = new Usuario("Gonzalo");
		Mensaje m = new Mensaje(u, LocalDateTime.now(), "HOLA");
		Set<Usuario> usuarios = new HashSet<Usuario>();
		List<Mensaje> mensajes = new ArrayList<Mensaje>();
		usuarios.add(u);
		mensajes.add(m);
		Sala s = new Sala("Sala1", usuarios, mensajes);
		
		
		
		try {
			SalaDAO.marshal(s, new File("Sala.xml"));
		} catch (IOException | JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		
	
	}
	
}

