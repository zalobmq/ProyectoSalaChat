package modelos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="sala")
public class Sala implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@XmlAttribute (name = "nombre")
	private String nombre;
	
	@XmlElementWrapper(name="ususariosConectados")
    @XmlElement(name = "usuario", type = Usuario.class)
	private Set<Usuario>  usuariosConectados;
    @XmlElementWrapper(name="mensajes")
    @XmlElement(name = "mensaje", type = Mensaje.class)

	private List<Mensaje> mensajes;
    
	public Sala() {
		super();
	}
	
	
	public Sala(String nombre) {
		super();
		this.nombre = nombre;
		this.usuariosConectados = new HashSet<Usuario>();
		this.mensajes = new ArrayList<Mensaje>();
	}


	public Sala(Set<Usuario> usuariosConectados) {
		super();
		this.usuariosConectados = usuariosConectados;
	}

	public Sala(String nombre, Set<Usuario> usuariosConectados, List<Mensaje> mensajes) {
		super();
		this.nombre = nombre;
		this.usuariosConectados = usuariosConectados;
		this.mensajes = mensajes;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Set<Usuario> getUsuariosConectados() {
		return usuariosConectados;
	}
	public void setUsuariosConectados(Set<Usuario> usuariosConectados) {
		this.usuariosConectados = usuariosConectados;
	}
	public List<Mensaje> getMensajes() {
		return mensajes;
	}
	public void setMensajes(List<Mensaje> mensajes) {
		this.mensajes = mensajes;
	}
}
