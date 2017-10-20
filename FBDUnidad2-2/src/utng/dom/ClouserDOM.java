package utng.dom;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import utng.model.Clouser;

public class ClouserDOM {
	private String pathFile = "C:\\Users\\Home\\eclipse-workspace\\FBDUnidad2-2\\src\\data\\clousers.xml";

	public void add(Clouser data) {
		try {

			Document document = DOMHelper.getDocument(pathFile);
			Element clousers = document.getDocumentElement();
			// Create clouser tag
			Element clouser = document.createElement("clouser");
			// Create id tag
			Element id = document.createElement("id");
			id.appendChild(document.createTextNode(data.getId()));
			clouser.appendChild(id);
			// Create name tag
			Element name = document.createElement("name");
			name.appendChild(document.createTextNode(data.getName()));
			clouser.appendChild(name);
			// Create create tag
			Element creatationDate = document.createElement("creationDate");
			creatationDate.appendChild(document.createTextNode(data.getCreationDate()));
			clouser.appendChild(creatationDate);

			Element modificationDate = document.createElement("modificationDate");
			modificationDate.appendChild(document.createTextNode(data.getModificationDate()));
			clouser.appendChild(modificationDate);
			// Create username tag
			Element username = document.createElement("username");
			username.appendChild(document.createTextNode(data.getName()));
			clouser.appendChild(username);
			clousers.appendChild(clouser);
			// Write to File
			DOMHelper.saveXMLContent(document, pathFile);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void delete(String id) {
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodeList = document.getElementsByTagName("clouser");
			for (int i = 0; i < nodeList.getLength(); i++) {
				Element clouser = (Element) nodeList.item(i);
				if (clouser.getElementsByTagName("id").item(0).getTextContent().equals(id)) {
					clouser.getParentNode().removeChild(clouser);
				}
			}
			DOMHelper.saveXMLContent(document, pathFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(Clouser data) {
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodeList = document.getElementsByTagName("clouser");
			for (int i = 0; i < nodeList.getLength(); i++) {
				Element clouser = (Element) nodeList.item(i);
				if (clouser.getElementsByTagName("id").item(0).getTextContent().equals(data.getId())) {
					clouser.getElementsByTagName("name").item(0).setTextContent(data.getName());
					clouser.getElementsByTagName("creationDate").item(0).setTextContent(data.getCreationDate());
					clouser.getElementsByTagName("modificationDate").item(0).setTextContent(data.getModificationDate());
					clouser.getElementsByTagName("username").item(0).setTextContent(data.getUsername());

				}
			}
			DOMHelper.saveXMLContent(document, pathFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Clouser findById(String id) {
		Clouser clouser = null;
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodeList = document.getElementsByTagName("clouser");
			for (int i = 0; i < nodeList.getLength(); i++) {
				Element s = (Element) nodeList.item(i);
				if (s.getElementsByTagName("id").item(0).getTextContent().equals(id)) {
					clouser = new Clouser();
					clouser.setId(id);
					clouser.setName(s.getElementsByTagName("name").item(0).getTextContent());
					clouser.setCreationDate(s.getElementsByTagName("creationDate").item(0).getTextContent());
					clouser.setModificationDate(s.getElementsByTagName("modificationDate").item(0).getTextContent());
					clouser.setUsername(s.getElementsByTagName("username").item(0).getTextContent());

				}

			}
			DOMHelper.saveXMLContent(document, pathFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clouser;
	}

	public List<Clouser> getClousers() {
		List<Clouser> clousers = new ArrayList<Clouser>();
		Document document = DOMHelper.getDocument(pathFile);
		NodeList nodeList = document.getElementsByTagName("clouser");
		for (int i = 0; i < nodeList.getLength(); i++) {
			Element s = (Element) nodeList.item(i);
			Clouser clouser = new Clouser();
			clouser.setId(s.getElementsByTagName("id").item(0).getTextContent());
			clouser.setName(s.getElementsByTagName("name").item(0).getTextContent());
			clouser.setCreationDate(s.getElementsByTagName("creationDate").item(0).getTextContent());
			clouser.setModificationDate(s.getElementsByTagName("modificationDate").item(0).getTextContent());
			clouser.setUsername(s.getElementsByTagName("username").item(0).getTextContent());
			clousers.add(clouser);
		}
		return clousers;
	}

}
