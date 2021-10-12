package modelos;

import java.io.Serializable;
import java.util.Objects;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="usuario")
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String nick;

	public Usuario() {
		super();
	}

	public Usuario(String nick) {
		super();
		this.nick = nick;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	@Override
	public boolean equals(Object obj) {
		 if (this == obj) return true;
	        if (obj == null || getClass() != obj.getClass()) return false;
	        Usuario user = (Usuario) obj;
	        return Objects.equals(nick, user.nick);		
	}

	

	
	
	
}
