package modelos;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="mensaje")
public class Mensaje implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;
	private String fecha;
	private String texto;
	
	
	public Mensaje() {
		super();
	}

	public Mensaje(Usuario usuario, String fecha, String texto) {
		super();
		this.usuario = usuario;
		this.fecha = fecha;
		this.texto = texto;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String setfechaXml() {
		return fecha.toString();
	}
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	
	
	
}
