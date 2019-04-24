package br.com.spcbrasil.test.data;

import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.stream.IntStream;

import javax.xml.parsers.DocumentBuilderFactory;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import br.com.spcbrasil.test.error.ExceptionHandler;
import br.com.spcbrasil.test.model.Paciente;

@SuppressWarnings("unused")
public class DataLoader {

	public static List<Paciente> getMockedData(List<Paciente> pacientes) {
		pacientes.add(new Paciente("Kleber Renato", 'M', 61.2f, 49, 1.71f));
		pacientes.add(new Paciente("Andrea Batista", 'F', 70.1f, 49, 1.70f));
		pacientes.add(new Paciente("Kleber Rodrigo", 'M', 61.2f, 30, 1.71f));
		pacientes.add(new Paciente("Marcos Aurélio", 'M', 61.2f, 28, 1.71f));
		pacientes.add(new Paciente("Andressa Cristine", 'F', 61.2f, 25, 1.70f));
		pacientes.add(new Paciente("Lucas Xavier", 'M', 61.2f, 23, 1.71f));
		return pacientes;
	}

//	@SuppressWarnings("unchecked")
	public static List<Paciente> getDataFromJSON(List<Paciente> pacientes) {
		try (FileReader reader = new FileReader("resources/pacientes.json")) {
			JSONObject obj = (JSONObject) new JSONParser().parse(reader);
			JSONArray lstPacientes = (JSONArray) obj.get("pacientes");
//			lstPacientes.forEach(paciente -> pacientes.add(parsePacienteObject((JSONObject) paciente)));
			int index = 0;
			while (!((JSONObject) lstPacientes.get(index)).get("nome").equals("fim")) {
				pacientes.add(parsePacienteObject((JSONObject) lstPacientes.get(index)));
				index++;
			}
		} catch (Exception e) {
			ExceptionHandler.handle(e);
		}
		return pacientes;
	}

	private static Paciente parsePacienteObject(JSONObject pacienteObject) {
		try {
			String nome = (String) pacienteObject.get("nome");
			char sexo = ((String) pacienteObject.get("sexo")).charAt(0);
			float peso = Float.valueOf((String) pacienteObject.get("peso"));
			int idade = Integer.valueOf((String) pacienteObject.get("idade"));
			float altura = Float.valueOf((String) pacienteObject.get("altura"));
			return new Paciente(nome, sexo, peso, idade, altura);
		} catch (Exception e) {
			ExceptionHandler.handle(e);
		}
		return new Paciente();
	}

	public static List<Paciente> getDataFromXML(List<Paciente> pacientes) {
		try {
			File file = new File("resources/pacientes.xml");
			Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
			document.getDocumentElement().normalize();

			NodeList nodeList = document.getElementsByTagName("paciente");
			/*IntStream.range(0, nodeList.getLength()).mapToObj(nodeList::item)
					.filter(node -> node.getNodeType() == Node.ELEMENT_NODE)
					.forEach(paciente -> pacientes.add(parsePacienteObject((Element) paciente)));*/
			int index = 0;
			while (!((Element) nodeList.item(index)).getElementsByTagName("nome").item(0).getTextContent().equals("fim")) {
				pacientes.add(parsePacienteObject((Element) nodeList.item(index)));
				index++;
			}
		} catch (Exception e) {
			ExceptionHandler.handle(e);
		}
		return pacientes;
	}

	private static Paciente parsePacienteObject(Element pacienteObject) {
		try {
			String nome = pacienteObject.getElementsByTagName("nome").item(0).getTextContent();
			char sexo = pacienteObject.getElementsByTagName("sexo").item(0).getTextContent().charAt(0);
			float peso = Float.valueOf(pacienteObject.getElementsByTagName("peso").item(0).getTextContent());
			int idade = Integer.valueOf(pacienteObject.getElementsByTagName("idade").item(0).getTextContent());
			float altura = Float.valueOf(pacienteObject.getElementsByTagName("altura").item(0).getTextContent());
			return new Paciente(nome, sexo, peso, idade, altura);
		} catch (Exception e) {
			ExceptionHandler.handle(e);
		}
		return new Paciente();
	}
}