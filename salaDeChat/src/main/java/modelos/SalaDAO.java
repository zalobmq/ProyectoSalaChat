package modelos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import utilidades.Utilidades;



public class SalaDAO {

	public static void marshal(Sala s , File f) throws IOException, JAXBException{		//GUARDAR XML
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(f));
			JAXBContext context= JAXBContext.newInstance(Sala.class);
			
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  //para que me ponga tabulado el xml
			m.setProperty(Marshaller.JAXB_ENCODING, "utf-8");
			
			m.marshal(s, writer);
			writer.close();
		}catch (IOException e) {
			e.printStackTrace();

		}	
				
	}
	
	public static Sala unmarshal(File f) throws JAXBException {
		Sala sala=null;
		
		BufferedReader read;
		try {
			read = new BufferedReader(new FileReader(f));
			JAXBContext context= JAXBContext.newInstance(Sala.class);
			Unmarshaller um = context.createUnmarshaller();
			sala = (Sala) um.unmarshal(read);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			try {
				sala=new Sala(f.toString().replace(".xml", ""));

				marshal(sala , f);
			} catch (IOException | JAXBException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//e.printStackTrace();
			Utilidades.MostrarError("ARCHIVO N0 EXITENTE", "NO SE PUDO LEER EL XML", "SE CREARA UNO NUEVO");
		}
	
		return sala;
		
	}
}


